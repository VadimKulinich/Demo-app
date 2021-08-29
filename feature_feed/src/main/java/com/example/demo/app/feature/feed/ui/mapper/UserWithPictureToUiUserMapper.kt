package com.example.demo.app.feature.feed.ui.mapper

import com.example.demo.app.core.data.db.entity.UserWithPicture
import com.example.demo.app.feature.feed.R
import com.example.demo.app.feature.feed.ui.model.UiUser
import com.example.demo.app.uilts.provider.StringProvider

class UserWithPictureToUiUserMapper(private val stringProvider: StringProvider) {

    fun map(userWithPicture: UserWithPicture): UiUser =
        with(userWithPicture) {
            UiUser(
                user.id,
                stringProvider.getString(
                    R.string.user_name_format,
                    user.title, user.firstName, user.lastName
                ),
                stringProvider.getString(
                    R.string.user_address_format,
                    address.street, address.number,
                    address.city, address.postcode
                ),
                user.phone,
                picture.url
            )
        }
}