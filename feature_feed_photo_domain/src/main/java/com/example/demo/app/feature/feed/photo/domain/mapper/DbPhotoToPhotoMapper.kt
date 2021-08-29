package com.example.demo.app.feature.feed.photo.domain.mapper

import com.example.demo.app.core.data.db.entity.photo.Photo as DbPhoto
import com.example.demo.app.feature.feed.photo.domain.model.Photo

internal class DbPhotoToPhotoMapper {

    fun map(photo: DbPhoto): Photo = with(photo) { Photo(id, author, url) }
}