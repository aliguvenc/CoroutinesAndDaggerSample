package com.github.aliguvenc.coroutinesanddagger.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.github.aliguvenc.coroutinesanddagger.PhotoModel
import com.github.aliguvenc.coroutinesanddagger.adapter.viewholders.PhotoViewHolder
import com.github.aliguvenc.coroutinesanddagger.listeners.SelectionListener

class PhotoRecyclerViewAdapter(private val selectionListener: SelectionListener) :
    ListAdapter<PhotoModel, PhotoViewHolder>(PHOTO_DIFF_UTIL) {

    companion object {
        val PHOTO_DIFF_UTIL = object : DiffUtil.ItemCallback<PhotoModel>() {
            override fun areItemsTheSame(oldItem: PhotoModel, newItem: PhotoModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: PhotoModel, newItem: PhotoModel): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder.createHolder(parent)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(getItem(position), selectionListener)
    }

}