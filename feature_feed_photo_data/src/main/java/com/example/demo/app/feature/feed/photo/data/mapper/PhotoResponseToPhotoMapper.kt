package com.example.demo.app.feature.feed.photo.data.mapper

import com.example.demo.app.core.data.db.entity.photo.Photo
import com.example.demo.app.feature.feed.photo.data.network.response.PhotoResponse

internal class PhotoResponseToPhotoMapper {

    fun map(photo: PhotoResponse): Photo =
        with(photo) { Photo(id, author, url) }
}