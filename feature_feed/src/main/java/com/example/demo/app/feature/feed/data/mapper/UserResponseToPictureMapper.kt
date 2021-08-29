package com.example.demo.app.feature.feed.data.mapper

import com.example.demo.app.core.data.model.UserPictureType
import com.example.demo.app.feature.feed.data.network.response.UserPicture
import com.example.demo.app.core.data.db.entity.UserPicture as DbUserPicture

class UserResponseToPictureMapper {

    fun map(id: String, userPicture: UserPicture): List<DbUserPicture> {
        val userPictures = mutableListOf<DbUserPicture>()
        with(userPicture) {
            userPictures.add(DbUserPicture(id, UserPictureType.THUMBNAIL, thumbnailUrl))
            userPictures.add(DbUserPicture(id, UserPictureType.MEDIUM, mediumUrl))
            userPictures.add(DbUserPicture(id, UserPictureType.LARGE, largeUrl))
        }
        return userPictures
    }
}