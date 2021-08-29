package com.example.demo.app.core.data.db.entity

import androidx.room.Embedded

data class UserWithThumbnail(
    @Embedded val user: User,
    @Embedded val thumbnail: UserPicture
)