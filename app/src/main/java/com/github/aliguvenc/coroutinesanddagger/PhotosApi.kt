package com.github.aliguvenc.coroutinesanddagger

import retrofit2.Response
import retrofit2.http.GET

interface PhotosApi {

    @GET("photos")
    suspend fun getProducts(): Response<List<PhotoModel>>

}