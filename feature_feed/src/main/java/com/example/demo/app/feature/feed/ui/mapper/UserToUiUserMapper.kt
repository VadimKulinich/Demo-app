package com.example.demo.app.feature.feed.ui.mapper

import com.example.demo.app.feature.feed.R
import com.example.demo.app.feature.feed.random.user.domain.model.User
import com.example.demo.app.feature.feed.ui.model.UiUser
import com.example.demo.app.uilts.provider.StringProvider

class UserToUiUserMapper(private val stringProvider: StringProvider) {

    fun map(user: User): UiUser =
        with(user) {
            UiUser(
                id,
                stringProvider.getString(
                    R.string.user_name_format,
                    title, firstName, lastName
                ),
                stringProvider.getString(
                    R.string.user_address_format,
                    street, number, city, postcode
                ),
                phone, url
            )
        }
}