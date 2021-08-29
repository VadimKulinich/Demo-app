package com.example.demo.app.feature.feed.random.user.data.network.response

import com.google.gson.annotations.SerializedName

internal data class UserPicture(
    @SerializedName("large") val largeUrl: String,
    @SerializedName("medium") val mediumUrl: String,
    @SerializedName("thumbnail") val thumbnailUrl: String
)