package com.example.demo.app.core.data.db.entity.photo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Photo(
    @ColumnInfo(name = "id") @PrimaryKey val id: String,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "url") val url: String
)