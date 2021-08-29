package com.example.demo.app.core.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.demo.app.core.data.db.dao.PhotoDao
import com.example.demo.app.core.data.db.dao.UserDao
import com.example.demo.app.core.data.db.entity.photo.Photo
import com.example.demo.app.core.data.db.entity.user.Address
import com.example.demo.app.core.data.db.entity.user.User
import com.example.demo.app.core.data.db.entity.user.UserPicture

@Database(
    entities = [Photo::class, Address::class, User::class, UserPicture::class],
    version = AppDatabase.VERSION
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val VERSION = 1
    }

    abstract val userDao: UserDao

    abstract val photoDao: PhotoDao
}