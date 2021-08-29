package com.example.demo.app.core.data.db.entity.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.demo.app.core.data.model.UserPictureType

@Entity(
    tableName = "user_picture",
    primaryKeys = ["user_id", "type"],
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["u_id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class UserPicture(
    @ColumnInfo(name = "user_id") val userId: String,
    @ColumnInfo(name = "type") @UserPictureType val type: Int,
    @ColumnInfo(name = "url") val url: String,
)