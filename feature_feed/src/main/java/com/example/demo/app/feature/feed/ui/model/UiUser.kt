package com.example.demo.app.feature.feed.ui.model

import com.example.demo.app.core.ui.adapter.model.ListItem

data class UiUser(
    override val id: String,
    val formattedName: String,
    val formattedAddress: String,
    val phone: String,
    val picture: String,
) : ListItem {

    override val type: Int
        get() = UI_USER_LIST_TYPE

    companion object {
        const val UI_USER_LIST_TYPE = 1
    }
}