package com.oleg.memoreitapp.find_photographer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.oleg.memoreitapp.R
import com.oleg.memoreitapp.bandung_photo_session.PhotoSessionOneFragment
import kotlinx.android.synthetic.main.activity_find_photographer.*

class FindPhotographerActivity : AppCompatActivity() {
    var prevMenuItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_photographer)
        findPhotographerBottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

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
        adapter.addFragment(PhotoSessionOneFragment.newInstance())
        adapter.addFragment(PhotoSessionTwoFragment.newInstance())
        viewPager.adapter = adapter
    }
}
