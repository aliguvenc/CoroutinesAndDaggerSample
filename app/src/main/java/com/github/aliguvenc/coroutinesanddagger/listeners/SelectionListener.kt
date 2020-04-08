package com.github.aliguvenc.coroutinesanddagger.listeners

import com.github.aliguvenc.coroutinesanddagger.PhotoModel

class SelectionListener(private val selection: (PhotoModel) -> Unit) {

    fun onSelection(photoModel: PhotoModel) = selection(photoModel)
}