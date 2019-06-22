package com.oleg.memoreitapp.payment

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cn.pedant.SweetAlert.SweetAlertDialog
import com.oleg.memoreitapp.R
import com.oleg.memoreitapp.find_city.FindCityActivity
import kotlinx.android.synthetic.main.activity_payment.*
import org.jetbrains.anko.startActivity

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        btn_booked_book.setOnClickListener {
            basicAlert()
        }
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

}
