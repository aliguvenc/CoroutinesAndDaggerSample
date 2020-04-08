package com.github.aliguvenc.coroutinesanddagger

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val photoRepository: PhotoRepository) :
    ViewModel() {

    val photos: LiveData<ApiResult<List<PhotoModel>>> = photoRepository.photoModelResult

    init {
        viewModelScope.launch {
            photoRepository.getProducts()
        }
    }

}