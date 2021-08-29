package com.example.demo.app.feature.feed.random.user.data.network.response

import com.google.gson.annotations.SerializedName

internal data class User(
    @SerializedName("id") val id: UserId,
    @SerializedName("name") val name: UserName,
    @SerializedName("location") val location: UserLocation,
    @SerializedName("picture") val picture: UserPicture,
    @SerializedName("phone") val phone: String,
    @SerializedName("dob") val birthday: UserBirthday
)