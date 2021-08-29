package com.example.demo.feature.feed.domain.api

import kotlinx.coroutines.flow.Flow

interface FeedRepository<F> {

    suspend fun fetch()

    suspend fun clear()

    fun observe(): Flow<List<F>>

}