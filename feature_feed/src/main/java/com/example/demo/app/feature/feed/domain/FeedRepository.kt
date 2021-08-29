package com.example.demo.app.feature.feed.domain

import com.example.demo.app.core.data.db.entity.FullUser
import com.example.demo.app.core.data.db.entity.UserWithPicture
import kotlinx.coroutines.flow.Flow

interface FeedRepository {

    suspend fun fetchUsers()

    suspend fun clear()

    fun observeFeed(): Flow<List<UserWithPicture>>

    suspend fun loadUser(id: String): FullUser

}