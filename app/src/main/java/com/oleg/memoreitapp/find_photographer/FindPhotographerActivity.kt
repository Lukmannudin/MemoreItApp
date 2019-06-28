package com.oleg.memoreitapp.find_photographer

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.oleg.memoreitapp.R
import com.oleg.memoreitapp.Utils
import com.oleg.memoreitapp.Utils.FIND_PHOTOGRAPHER_PAGE_PROFESSIONAL
import com.oleg.memoreitapp.Utils.FIND_PHOTOGRAPHER_PAGE_SEMIPRO
import com.oleg.memoreitapp.Utils.SIMPLE_INTENT_NAME
import com.oleg.memoreitapp.bandung_photo_session.PhotoSessionFragment
import com.oleg.memoreitapp.model.Order
import kotlinx.android.synthetic.main.activity_find_photographer.*

class FindPhotographerActivity : AppCompatActivity() {
    var prevMenuItem: MenuItem? = null
    private lateinit var order: Order

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_photographer)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Find Photographer"

        val intent = intent.getParcelableExtra<Order>(SIMPLE_INTENT_NAME)
        order = intent

        findPhotographerBottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        findPhotographerBottomNavigationView.itemIconTintList = null
        findPhotographerViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                if (prevMenuItem != null){
                    prevMenuItem?.isChecked = false
                } else {
                    findPhotographerBottomNavigationView.menu.getItem(0).isChecked = false
                }

                val bottomIconActive = findPhotographerBottomNavigationView.menu.getItem(position)
                bottomIconActive.isChecked = true

                prevMenuItem = bottomIconActive
            }
        })
        setupViewPager(findPhotographerViewPager)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.item_semi_pro_photo_session -> {
                findPhotographerViewPager.currentItem = 0
            }
            R.id.item_professional_photo_session -> {
                findPhotographerViewPager.currentItem = 1
            }
            else -> {
                findPhotographerViewPager.currentItem = 0
            }
        }
        true

    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = PhotoSessionAdapter(supportFragmentManager)

        order.service = FIND_PHOTOGRAPHER_PAGE_SEMIPRO
        adapter.addFragment(PhotoSessionFragment.newInstance(order, FIND_PHOTOGRAPHER_PAGE_SEMIPRO))

        order.service = FIND_PHOTOGRAPHER_PAGE_PROFESSIONAL
        adapter.addFragment(PhotoSessionFragment.newInstance(order, FIND_PHOTOGRAPHER_PAGE_PROFESSIONAL))

        viewPager.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
