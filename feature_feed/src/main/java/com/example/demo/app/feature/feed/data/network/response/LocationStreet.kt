package com.example.demo.app.feature.feed.data.network.response

import com.google.gson.annotations.SerializedName

data class LocationStreet(
    @SerializedName("name") val name: String,
    @SerializedName("number") val number: String
)