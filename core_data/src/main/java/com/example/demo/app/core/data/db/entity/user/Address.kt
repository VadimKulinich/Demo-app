package com.example.demo.app.core.data.db.entity.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "address"
)
data class Address(
    @ColumnInfo(name = "a_id") @PrimaryKey val id: String,
    @ColumnInfo(name = "street") val street: String,
    @ColumnInfo(name = "number") val number: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "postcode") val postcode: String
)