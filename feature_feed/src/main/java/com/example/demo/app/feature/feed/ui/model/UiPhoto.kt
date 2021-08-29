package com.example.demo.app.feature.feed.ui.model

import com.example.demo.app.core.ui.adapter.model.ListItem

data class UiPhoto(
    override val id: String,
    val author: String,
    val url: String,
) : ListItem {

    override val type: Int
        get() = PHOTO_LIST_ITEM

    companion object {
        const val PHOTO_LIST_ITEM = 2
    }
}