package com.oleg.memoreitapp.response

import com.google.gson.annotations.SerializedName

data class RootResponse<T>(
    @SerializedName("data")
    val data: List<T>,

    @SerializedName("status")
    val status : String
)
