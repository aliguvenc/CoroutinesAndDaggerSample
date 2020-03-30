package com.github.aliguvenc.coroutinesanddagger

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.aliguvenc.coroutinesanddagger.di.ActivityScope
import com.github.aliguvenc.coroutinesanddagger.extesions.apiCall
import javax.inject.Inject

@ActivityScope
class ProductRepository @Inject constructor(private val productApi: ProductApi) : Api {

    private val _productResult = MutableLiveData<ApiResult<Product>>()

    val productResult: LiveData<ApiResult<Product>>
        get() = _productResult

    suspend fun getProducts() {
        _productResult.postValue(
            apiCall { productApi.getProducts() }
        )
    }
}