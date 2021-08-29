package com.example.demo.app.core.data.db.entity

import androidx.room.Embedded

data class FullUser(
    @Embedded val user: User,
    @Embedded val address: Address,
    @Embedded val pictures: List<UserPicture>
)