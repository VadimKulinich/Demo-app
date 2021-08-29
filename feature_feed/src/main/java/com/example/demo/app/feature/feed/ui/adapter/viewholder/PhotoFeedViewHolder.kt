package com.example.demo.app.feature.feed.ui.adapter.viewholder

import com.bumptech.glide.Glide
import com.example.demo.app.core.ui.adapter.holder.MultiTypeViewHolder
import com.example.demo.app.feature.feed.R
import com.example.demo.app.feature.feed.databinding.ItemPhotoFeedBinding
import com.example.demo.app.feature.feed.ui.model.UiPhoto

class PhotoFeedViewHolder(
    private val binding: ItemPhotoFeedBinding
) : MultiTypeViewHolder<UiPhoto>(binding.root) {

    override fun bind(model: UiPhoto) {
        Glide.with(binding.photo)
            .load(model.url)
            .placeholder(R.drawable.placeholder)
            .into(binding.photo)
        binding.title.text = model.author
    }
}