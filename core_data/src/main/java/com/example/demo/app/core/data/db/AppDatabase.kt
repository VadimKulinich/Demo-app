package com.example.demo.app.core.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.demo.app.core.data.db.dao.CommentDao
import com.example.demo.app.core.data.db.dao.UserDao
import com.example.demo.app.core.data.db.entity.Address
import com.example.demo.app.core.data.db.entity.Comment
import com.example.demo.app.core.data.db.entity.User
import com.example.demo.app.core.data.db.entity.UserPicture

@Database(
    entities = [Address::class, User::class, UserPicture::class, Comment::class],
    version = AppDatabase.VERSION
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val VERSION = 1
    }

    abstract val userDao: UserDao

    abstract val commentDao: CommentDao
}