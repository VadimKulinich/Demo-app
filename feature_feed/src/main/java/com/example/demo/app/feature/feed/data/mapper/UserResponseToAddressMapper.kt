package com.example.demo.app.feature.feed.data.mapper

import com.example.demo.app.core.data.db.entity.Address
import com.example.demo.app.feature.feed.data.network.response.User
import java.util.*

class UserResponseToAddressMapper {

    fun map(user: User): Address =
        with(user.location) {
            Address(
                UUID.randomUUID().toString(),
                street.name, street.number,
                city, postcode,
            )
        }
}