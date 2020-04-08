package com.github.aliguvenc.coroutinesanddagger

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.aliguvenc.coroutinesanddagger.di.ActivityScope
import com.github.aliguvenc.coroutinesanddagger.extensions.apiCall
import javax.inject.Inject

@ActivityScope
class PhotoRepository @Inject constructor(private val photosApi: PhotosApi) : Api {

    private val _productResult = MutableLiveData<ApiResult<List<PhotoModel>>>()

    val photoModelResult: LiveData<ApiResult<List<PhotoModel>>>
        get() = _productResult

    suspend fun getProducts() {
        _productResult.postValue(
            apiCall { photosApi.getProducts() }
        )
    }
}