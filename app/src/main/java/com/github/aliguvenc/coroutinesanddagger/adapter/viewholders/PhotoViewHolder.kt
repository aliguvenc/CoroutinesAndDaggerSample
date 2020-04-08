package com.github.aliguvenc.coroutinesanddagger.adapter.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.aliguvenc.coroutinesanddagger.PhotoModel
import com.github.aliguvenc.coroutinesanddagger.databinding.ListItemPhotoBinding
import com.github.aliguvenc.coroutinesanddagger.listeners.SelectionListener

class PhotoViewHolder(private val viewBinding: ListItemPhotoBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {

    companion object {
        fun createHolder(parent: ViewGroup): PhotoViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemPhotoBinding.inflate(layoutInflater, parent, false)
            return PhotoViewHolder(binding)
        }
    }

    fun bind(
        photoModel: PhotoModel,
        selectionListener: SelectionListener
    ) {
        viewBinding.run {
            photo = photoModel
            selection = selectionListener
            executePendingBindings()
        }
    }
}