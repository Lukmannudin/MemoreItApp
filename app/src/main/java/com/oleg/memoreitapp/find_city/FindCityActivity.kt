package com.oleg.memoreitapp.find_city

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.oleg.memoreitapp.R
import kotlinx.android.synthetic.main.activity_find_city.*

class FindCityActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_city)
        supportActionBar?.title = "Find City"
        setupViewPager(findcityViewPager)

    }


    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = FindCityPagerAdapter(supportFragmentManager)
        adapter.addFragment(CityOneFragment.newInstance(),"Bandung")
        adapter.addFragment(CityTwoFragment.newInstance(),"Yogyakarta")
        viewPager.adapter = adapter
        find_city_tab_layout.setupWithViewPager(viewPager)
    }
}
