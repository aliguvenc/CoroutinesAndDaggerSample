package com.github.aliguvenc.coroutinesanddagger

import javax.inject.Inject

class ProductRepository @Inject constructor(private val productApi: ProductApi) : Api {

    suspend fun getProducts(): ApiResult<Product> = call {
        productApi.getProducts()
    }
}