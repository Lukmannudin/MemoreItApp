package com.oleg.memoreitapp

import com.google.gson.annotations.SerializedName

data class TestResponse(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null
)