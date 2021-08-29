package com.example.demo.app.feature.feed.ui.adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.demo.app.core.ui.adapter.delegate.AdapterDelegate
import com.example.demo.app.feature.feed.databinding.ItemPhotoFeedBinding
import com.example.demo.app.feature.feed.ui.adapter.viewholder.PhotoFeedViewHolder
import com.example.demo.app.feature.feed.ui.model.UiPhoto

class PhotoFeedDelegate : AdapterDelegate<UiPhoto, PhotoFeedViewHolder>() {
    override val viewType: Int
        get() = UiPhoto.PHOTO_LIST_ITEM

    override fun createHolder(parent: ViewGroup, inflater: LayoutInflater): PhotoFeedViewHolder =
        PhotoFeedViewHolder(ItemPhotoFeedBinding.inflate(inflater, parent, false))

}