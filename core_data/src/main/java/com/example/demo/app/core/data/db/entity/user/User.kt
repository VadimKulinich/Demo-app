package com.example.demo.app.core.data.db.entity.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "user",
    foreignKeys = [
        ForeignKey(
            entity = Address::class,
            parentColumns = ["a_id"],
            childColumns = ["address_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class User(
    @ColumnInfo(name = "u_id") @PrimaryKey val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "birthday") val birthday: String,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "update_time") val timestamp: Long,
    @ColumnInfo(name = "address_id") val addressId: String
)