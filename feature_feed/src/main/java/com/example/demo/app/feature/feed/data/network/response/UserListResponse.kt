package com.example.demo.app.feature.feed.data.network.response

import com.google.gson.annotations.SerializedName

data class UserListResponse(
    @SerializedName("results") val users: List<User>,
    @SerializedName("info") val pagination: Pagination
)