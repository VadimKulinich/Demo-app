package com.example.demo.app.feature.feed.random.user.data.mapper

import com.example.demo.app.core.data.db.entity.user.Address
import com.example.demo.app.feature.feed.random.user.data.network.response.User
import java.util.*

internal class UserResponseToAddressMapper {

    fun map(user: User): Address =
        with(user.location) {
            Address(
                UUID.randomUUID().toString(),
                street.name, street.number,
                city, postcode,
            )
        }
}