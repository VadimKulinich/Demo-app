package com.example.demo.app.feature.feed.data.network.response

import com.google.gson.annotations.SerializedName

data class UserLocation(
    @SerializedName("street") val street: LocationStreet,
    @SerializedName("city") val city: String,
    @SerializedName("country") val country: String,
    @SerializedName("postcode") val postcode: String,
    @SerializedName("coordinates") val coordinates: UserLocationCoordinates
)