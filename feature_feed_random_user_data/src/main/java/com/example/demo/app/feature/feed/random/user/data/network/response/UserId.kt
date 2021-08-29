package com.example.demo.app.feature.feed.random.user.data.network.response

import com.google.gson.annotations.SerializedName

internal data class UserId(
    @SerializedName("value") val value: String?
)