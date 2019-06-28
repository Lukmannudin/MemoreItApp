package com.oleg.memoreitapp.review_booking

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.oleg.memoreitapp.R
import com.oleg.memoreitapp.Utils
import com.oleg.memoreitapp.add_info.AddInfoActivity
import com.oleg.memoreitapp.model.Order
import kotlinx.android.synthetic.main.activity_review_booking.*
import org.jetbrains.anko.startActivity

class ReviewBookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_booking)

        val intent = intent.getParcelableExtra<Order>(Utils.SIMPLE_INTENT_NAME)

        btn_review_booking_country.setOnClickListener {

            startActivity<AddInfoActivity>(
                Utils.SIMPLE_INTENT_NAME to intent
            )
        }

        supportActionBar?.title = "Review Booking"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        tv_review_booking_title.text = intent.service
        tv_review_booking_duration.text = intent.duration
        tv_review_booking_divider_price.text = intent.price
        tv_review_booking_date.text = intent.date
        tv_review_booking_at_time.text = intent.at
        tv_review_booking_city.text = intent.city+", "
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home){
            onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }
}
