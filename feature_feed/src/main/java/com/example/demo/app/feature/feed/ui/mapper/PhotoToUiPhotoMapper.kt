package com.example.demo.app.feature.feed.ui.mapper

import com.example.demo.app.feature.feed.photo.domain.model.Photo
import com.example.demo.app.feature.feed.ui.model.UiPhoto

class PhotoToUiPhotoMapper {

    fun map(photo: Photo): UiPhoto =
        with(photo) { UiPhoto(id, author, url) }
}