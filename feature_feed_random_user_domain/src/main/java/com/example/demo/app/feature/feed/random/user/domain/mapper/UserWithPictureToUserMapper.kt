package com.example.demo.app.feature.feed.random.user.domain.mapper

import com.example.demo.app.core.data.db.entity.user.UserWithPicture
import com.example.demo.app.feature.feed.random.user.domain.model.User

internal class UserWithPictureToUserMapper {

    fun map(userWithPicture: UserWithPicture): User =
        with(userWithPicture) {
            User(
                user.id, user.title, user.firstName,
                user.lastName, user.phone,
                address.street, address.number,
                address.city, address.postcode,
                picture.url
            )
        }
}