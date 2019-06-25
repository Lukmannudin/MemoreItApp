package com.oleg.memoreitapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Order(
    var city:String = "",
    var service: String  = "",
    var duration: String = "",
    var price: String = "",
    var date: String = "",
    var at: String = ""
) : Parcelable