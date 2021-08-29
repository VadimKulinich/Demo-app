package com.example.demo.app.feature.feed.random.user.data.network

import com.example.demo.app.feature.feed.random.user.data.network.response.UserListResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface UserApi {

    @GET("api")
    suspend fun loadUsers(
        @Query("results") results: Int
    ): UserListResponse
}