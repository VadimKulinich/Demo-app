package com.example.demo.app.core.data.db.entity

import androidx.room.Embedded
import androidx.room.Relation

data class FullUser(
    @Embedded val user: User,
    @Embedded val address: Address,
    @Relation(
        parentColumn = "u_id",
        entityColumn = "user_id"
    ) val pictures: List<UserPicture>
)