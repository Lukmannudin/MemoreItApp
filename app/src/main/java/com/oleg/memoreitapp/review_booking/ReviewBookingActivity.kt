package com.oleg.memoreitapp.review_booking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oleg.memoreitapp.R
import com.oleg.memoreitapp.add_info.AddInfoActivity
import kotlinx.android.synthetic.main.activity_review_booking.*
import org.jetbrains.anko.startActivity

class ReviewBookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_booking)
        btn_review_booking_country.setOnClickListener {
            startActivity<AddInfoActivity>()
        }
    }
}
