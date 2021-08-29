package com.example.demo.app.feature.feed.ui.adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.demo.app.core.ui.adapter.delegate.AdapterDelegate
import com.example.demo.app.feature.feed.databinding.ItemUserFeedBinding
import com.example.demo.app.feature.feed.ui.adapter.viewholder.UserFeedViewHolder
import com.example.demo.app.feature.feed.ui.model.UiUser

class UserFeedDelegate : AdapterDelegate<UiUser, UserFeedViewHolder>() {

    override val viewType: Int
        get() = UiUser.UI_USER_LIST_TYPE

    override fun createHolder(parent: ViewGroup, inflater: LayoutInflater): UserFeedViewHolder =
        UserFeedViewHolder(ItemUserFeedBinding.inflate(inflater, parent, false))
}