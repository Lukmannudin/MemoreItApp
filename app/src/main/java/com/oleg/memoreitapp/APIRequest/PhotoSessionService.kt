package com.oleg.memoreitapp.APIRequest

import com.oleg.memoreitapp.model.Order
import com.oleg.memoreitapp.model.PhotoSession
import com.oleg.memoreitapp.response.PostResponse
import com.oleg.memoreitapp.response.RootResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PhotoSessionService {

    @GET("service/")
    fun getPhotoSessionServicePro(@Query("filter") filter: String):
            Observable<RootResponse<PhotoSession>>

    @POST("booking/")
    fun postOrder(@Body order: Order):
            Observable<PostResponse<String>>


}