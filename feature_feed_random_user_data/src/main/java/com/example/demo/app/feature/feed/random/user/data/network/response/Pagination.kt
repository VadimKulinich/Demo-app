package com.example.demo.app.feature.feed.random.user.data.network.response

import com.google.gson.annotations.SerializedName

internal data class Pagination(
    @SerializedName("results") val results: Int,
    @SerializedName("page") val page: Int
)