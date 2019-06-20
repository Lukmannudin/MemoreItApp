package com.oleg.memoreitapp.FindCity

import com.oleg.memoreitapp.R

enum class FindCityEnum private constructor(
    val titleResId : Int,
    val layoutResId : Int
) {
    CITY_ONE(0, R.layout.findcity_one),
    CITY_TWO(1, R.layout.findcity_two)
}