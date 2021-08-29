package com.example.demo.app.core.data.db.entity.user

import androidx.room.Embedded

data class UserWithPicture(
    @Embedded val user: User,
    @Embedded val address: Address,
    @Embedded val picture: UserPicture,
)