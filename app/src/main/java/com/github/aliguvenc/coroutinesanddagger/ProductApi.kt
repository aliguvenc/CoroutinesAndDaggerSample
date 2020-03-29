package com.github.aliguvenc.coroutinesanddagger

import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {

    @GET("products.json")
    suspend fun getProducts(): Response<Product>

}