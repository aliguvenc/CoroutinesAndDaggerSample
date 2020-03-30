package com.github.aliguvenc.coroutinesanddagger

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import javax.inject.Inject

class MainViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {

    val products: LiveData<ApiResult<Product>> = liveData {
        emitSource(productRepository.productResult)
    }
}