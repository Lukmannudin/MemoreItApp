package com.oleg.memoreitapp.pick_date

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.oleg.memoreitapp.Utils
import com.oleg.memoreitapp.model.Order
import com.oleg.memoreitapp.review_booking.ReviewBookingActivity
import kotlinx.android.synthetic.main.activity_pick_date.*



class PickDateActivity : AppCompatActivity() {
    var checkedRadioButton: RadioButton? = null
    private lateinit var order: Order

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.oleg.memoreitapp.R.layout.activity_pick_date)
        pick_date_btn_next.setOnClickListener {
            val intent = Intent(this,ReviewBookingActivity::class.java)
            intent.putExtra(Utils.SIMPLE_INTENT_NAME,order)
            startActivity(intent)
        }
        supportActionBar?.title = "Pick Date"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

            val intent = intent.getParcelableExtra<Order>(Utils.SIMPLE_INTENT_NAME)
            order = intent
        pick_date_calendarview.setOnDateChangeListener { view, year, month, dayOfMonth ->
            order.date = "$dayOfMonth $month $dayOfMonth"
        }

        pick_date_calendarview.minDate = System.currentTimeMillis() - 1000

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home){
            onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }


    fun onClickRadioButton(view: View){
        val radioButton = view as RadioButton
        if (checkedRadioButton != null){
            checkedRadioButton!!.isChecked = false
        }
        radioButton.isChecked = true

        checkedRadioButton = radioButton

        order.at = radioButton.text.toString()
    }

    private fun getCheckedRadiButtonId(): Int {
        return checkedRadioButton?.id ?: 0
    }
}
