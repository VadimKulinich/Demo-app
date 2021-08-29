package com.example.demo.app.feature.feed.data.network

import com.example.demo.app.feature.feed.data.network.response.UserListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {

    @GET("api")
    suspend fun loadUsers(
        @Query("results") results: Int = 5
    ): UserListResponse
}