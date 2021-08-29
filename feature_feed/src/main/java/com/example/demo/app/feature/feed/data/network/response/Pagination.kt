package com.example.demo.app.feature.feed.data.network.response

import com.google.gson.annotations.SerializedName

data class Pagination(
    @SerializedName("results") val results: Int,
    @SerializedName("page") val page: Int
)