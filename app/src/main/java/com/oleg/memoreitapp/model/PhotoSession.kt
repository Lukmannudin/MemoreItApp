package com.oleg.memoreitapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoSession(
    val imageUrl: String,
    val title: String,
    val long: Int,
    val price: Int
) : Parcelable