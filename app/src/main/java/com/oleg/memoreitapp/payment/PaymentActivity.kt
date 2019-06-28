package com.oleg.memoreitapp.payment

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import cn.pedant.SweetAlert.SweetAlertDialog
import com.oleg.memoreitapp.APIRequest.PhotoSessionService
import com.oleg.memoreitapp.R
import com.oleg.memoreitapp.Utils
import com.oleg.memoreitapp.find_city.FindCityActivity
import com.oleg.memoreitapp.model.Order
import com.oleg.memoreitapp.service.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_payment.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class PaymentActivity : AppCompatActivity() {

    private var disposable:Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        val intent = intent.getParcelableExtra<Order>(Utils.SIMPLE_INTENT_NAME)

        btn_booked_book.setOnClickListener {
            sendPost(intent)
        }

        supportActionBar?.title = "Payment Booking"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun basicAlert() {
        SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
            .setTitleText("Great, You’re Booked!")
            .setContentText("A confirmation email is on its way to you.")
            .setConfirmClickListener {
                startActivity<FindCityActivity>()
            }
            .show()
    }



    private fun sendPost(data:Order){
        val service: PhotoSessionService = ApiService.photoSessionService
        val order = Order()

        val selectedId =payment_radio_group.checkedRadioButtonId

        val buttonSelected = findViewById<RadioButton>(selectedId)

        order.email_customer = data.email_customer
        order.name_customer = data.name_customer
        order.phone_number = data.phone_number
        order.id_service = data.id_service
        order.date_time = data.date+" "+data.at

        order.payment = "Transfer"
        if (buttonSelected.id != R.id.payment_payinperson_radio_button){
            order.payment = "Paypal"
        }

        order.message = data.message

        disposable = service.postOrder(order)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    basicAlert()
                },
                { error ->
                    toast("Sorry, can't order for moment")
                    Log.e("Error", error.message)
                }
            )
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home){
            onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

}
