package com.oleg.memoreitapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class PhotoSession(
//    val imageUrl: String,
//    val title: String,
//    val duration: Int,
//    val price: Int
    @SerializedName("id_service")
    var idService: String? = null,

    @SerializedName("name_service")
    var title: String? = null,

    @SerializedName("city")
    var city: String? = null,

    @SerializedName("price")
    var price: Int? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("duration")
    var duration: Int? = null,

    @SerializedName("picture")
    var imageUrl: String? = null,

    @SerializedName("kate")
    var category: String? = null,

    @SerializedName("payment")
    var payment: String? = null
) : Parcelable



