package com.example.demo.app.feature.feed.data.network.response

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id") val id: UserId,
    @SerializedName("name") val name: UserName,
    @SerializedName("location") val location: UserLocation,
    @SerializedName("picture") val picture: UserPicture,
    @SerializedName("phone") val phone: String,
    @SerializedName("dob") val birthday: UserBirthday
)