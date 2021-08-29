package com.example.demo.app.feature.feed.random.user.data.network.response

import com.google.gson.annotations.SerializedName

internal data class UserListResponse(
    @SerializedName("results") val users: List<User>,
    @SerializedName("info") val pagination: Pagination
)