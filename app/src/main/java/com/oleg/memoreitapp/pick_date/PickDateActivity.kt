package com.oleg.memoreitapp.pick_date

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oleg.memoreitapp.R
import com.oleg.memoreitapp.review_booking.ReviewBookingActivity
import kotlinx.android.synthetic.main.activity_pick_date.*
import org.jetbrains.anko.startActivity

class PickDateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_date)
        pick_date_btn_next.setOnClickListener {
            startActivity<ReviewBookingActivity>()
        }
    }
}
