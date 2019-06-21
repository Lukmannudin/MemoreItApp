package com.oleg.memoreitapp.find_city

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FindCityPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

    private var mFragmentList: MutableList<Fragment> = mutableListOf()

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    fun addFragment(fragment: Fragment){
        mFragmentList.add(fragment)
    }

}