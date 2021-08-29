package com.example.demo.app.feature.feed.ui.adapter.viewholder

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.demo.app.core.ui.adapter.holder.MultiTypeViewHolder
import com.example.demo.app.feature.feed.databinding.ItemUserFeedBinding
import com.example.demo.app.feature.feed.ui.model.UiUser

class UserFeedViewHolder(
    private val binding: ItemUserFeedBinding
) : MultiTypeViewHolder<UiUser>(binding.root) {

    override fun bind(model: UiUser) {
        Glide.with(binding.avatar)
            .load(model.picture)
            .transform(CircleCrop())
            .into(binding.avatar)
        binding.formattedName.text = model.formattedName
        binding.formattedAddress.text = model.formattedAddress
        binding.phone.text = model.phone
    }
}