package com.example.demo.app.core.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.example.demo.app.core.data.model.UserPictureType

@Entity(
    tableName = "user_picture",
    primaryKeys = ["user_id", "type"]
)
data class UserPicture(
    @ColumnInfo(name = "user_id") val userId: String,
    @ColumnInfo(name = "type") @UserPictureType val type: Int,
    @ColumnInfo(name = "url") val url: String,
)