package com.github.aliguvenc.coroutinesanddagger.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.aliguvenc.coroutinesanddagger.ApiResult
import com.github.aliguvenc.coroutinesanddagger.PhotoModel
import com.github.aliguvenc.coroutinesanddagger.adapter.PhotoRecyclerViewAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("url")
fun ImageView.imageFromUrl(url: String) {
    Picasso.get().load(url).into(this)
}

@BindingAdapter("photoList")
fun RecyclerView.refreshList(photoResult: ApiResult<List<PhotoModel>>?) {
    when (photoResult) {
        is ApiResult.Success -> {
            (adapter as PhotoRecyclerViewAdapter).submitList(photoResult.data)
        }
        is ApiResult.Error -> {

        }
    }
}