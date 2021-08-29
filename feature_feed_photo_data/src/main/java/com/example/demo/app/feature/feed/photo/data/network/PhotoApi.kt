package com.example.demo.app.feature.feed.photo.data.network

import com.example.demo.app.feature.feed.photo.data.network.response.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface PhotoApi {

    @GET("list")
    suspend fun loadPhotos(
        @Query("limit") limits: Int
    ): List<PhotoResponse>
}