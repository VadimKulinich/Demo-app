package com.example.demo.app.feature.feed.data.mapper

import android.os.SystemClock
import com.example.demo.app.feature.feed.data.network.response.User
import java.util.*
import com.example.demo.app.core.data.db.entity.User as DbUser

class UserResponseToUserMapper {

    fun map(user: User, addressId: String): DbUser =
        with(user) {
            DbUser(
                id.value ?: UUID.randomUUID().toString(),
                name.title, name.first, name.last, birthday.date,
                phone, SystemClock.elapsedRealtime(), addressId
            )
        }
}