package com.example.demo.app.feature.feed.photo.data.network.response

import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("id") val id: String,
    @SerializedName("author") val author: String,
    @SerializedName("download_url") val url: String
)