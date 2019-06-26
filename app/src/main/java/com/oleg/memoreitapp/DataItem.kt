package com.oleg.memoreitapp

import com.google.gson.annotations.SerializedName

data class DataItem(

    @field:SerializedName("duration")
    val duration: String? = null,

    @field:SerializedName("name_service")
    val nameService: String? = null,

    @field:SerializedName("city")
    val city: String? = null,

    @field:SerializedName("kate")
    val kate: String? = null,

    @field:SerializedName("price")
    val price: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("payment")
    val payment: String? = null,

    @field:SerializedName("picture")
    val picture: String? = null,

    @field:SerializedName("id_service")
    val idService: String? = null
)