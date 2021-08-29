package com.example.demo.app.core.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "comment",
    primaryKeys = ["from_user_id", "to_user_id"],
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["from_user_id"]
        ),
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["to_user_id"]
        )
    ]
)
data class Comment(
    @ColumnInfo(name = "from_user_id") val fromUserId: String,
    @ColumnInfo(name = "to_user_id") val toUserId: String,
    @ColumnInfo(name = "text") val text: String,
    @ColumnInfo(name = "likes") val likes: Int
)