package com.github.aliguvenc.coroutinesanddagger

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import javax.inject.Inject


class SecondViewModel @Inject constructor(private val photoRepository: PhotoRepository) :
    ViewModel() {

    val products: LiveData<ApiResult<List<PhotoModel>>> = liveData {
        emitSource(photoRepository.photoModelResult)
    }
}