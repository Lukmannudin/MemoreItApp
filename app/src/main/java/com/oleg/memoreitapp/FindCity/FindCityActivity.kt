package com.oleg.memoreitapp.FindCity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.oleg.memoreitapp.R

class FindCityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_city)

        val viewPager = findViewById<View>(R.id.findcityViewPager) as ViewPager
        viewPager.adapter = FindCityPagerAdapter(this)
    }
}
