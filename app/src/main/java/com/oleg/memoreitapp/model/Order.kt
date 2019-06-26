package com.oleg.memoreitapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Order(
    @SerializedName("email_customer")
    var email_customer:String ="",

    @SerializedName("name_customer")
    var name_customer:String = "",

    @SerializedName("phone_number")
    var phone_number:String = "",

    @SerializedName("id_service")
    var id_service:String = "1",

    @SerializedName("date_time")
    var date_time:String ="",

    @SerializedName("message")
    var message:String ="",

    var city:String = "",
    var service: String  = "",
    var duration: String = "",
    var price: String = "",
    var date: String = "",
    var at: String = ""

) : Parcelable