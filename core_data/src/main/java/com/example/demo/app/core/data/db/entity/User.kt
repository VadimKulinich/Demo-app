package com.example.demo.app.core.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "user"
)
data class User(
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "birthday") val birthday: Long,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "address_id") val addressId: String
)