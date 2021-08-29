package com.example.demo.app.feature.feed.random.user.data.mapper

import android.os.SystemClock
import com.example.demo.app.feature.feed.random.user.data.network.response.User
import java.util.*
import com.example.demo.app.core.data.db.entity.user.User as DbUser

internal class UserResponseToUserMapper {

    fun map(user: User, addressId: String): DbUser =
        with(user) {
            DbUser(
                id.value ?: UUID.randomUUID().toString(),
                name.title, name.first, name.last, birthday.date,
                phone, SystemClock.elapsedRealtime(), addressId
            )
        }
}