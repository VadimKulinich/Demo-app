package com.example.demo.app.feature.feed.data.network.response

import com.google.gson.annotations.SerializedName

data class UserPicture(
    @SerializedName("large") val largeUrl: String,
    @SerializedName("medium") val mediumUrl: String,
    @SerializedName("thumbnail") val thumbnailUrl: String
)