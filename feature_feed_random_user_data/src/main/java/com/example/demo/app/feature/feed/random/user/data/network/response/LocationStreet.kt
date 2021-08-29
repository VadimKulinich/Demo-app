package com.example.demo.app.feature.feed.random.user.data.network.response

import com.google.gson.annotations.SerializedName

internal data class LocationStreet(
    @SerializedName("name") val name: String,
    @SerializedName("number") val number: String
)