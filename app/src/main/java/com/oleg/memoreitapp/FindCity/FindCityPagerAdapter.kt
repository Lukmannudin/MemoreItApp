package com.oleg.memoreitapp.FindCity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class FindCityPagerAdapter (private val mContext: Context): PagerAdapter(){

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val modelObject = FindCityEnum.values()[position]
        val infalter = LayoutInflater.from(mContext)
        val layout = infalter.inflate(modelObject.layoutResId,container,false) as ViewGroup
        container.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return FindCityEnum.values().size
    }

}