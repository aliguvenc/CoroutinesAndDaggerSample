package com.github.aliguvenc.coroutinesanddagger

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import javax.inject.Inject

class SecondViewModel @Inject constructor(private val productRepository: ProductRepository)  : ViewModel() {

    val products: LiveData<ApiResult<Product>> = liveData {
        val data = productRepository.getProducts()
        emit(data)
    }
}