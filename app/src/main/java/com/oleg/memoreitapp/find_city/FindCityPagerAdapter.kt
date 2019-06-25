package com.oleg.memoreitapp.find_city

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FindCityPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

    private var mFragmentList: MutableList<Fragment> = mutableListOf()
    private var mFragmentTitleList: MutableList<String> = mutableListOf()

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }

    fun addFragment(fragment: Fragment, title: String){
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

}