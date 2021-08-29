package com.example.demo.app.feature.feed.photo.data

import com.example.demo.app.core.data.db.dao.PhotoDao
import com.example.demo.app.core.data.db.entity.photo.Photo
import com.example.demo.app.feature.feed.photo.data.mapper.PhotoResponseToPhotoMapper
import com.example.demo.app.feature.feed.photo.data.network.PhotoApi
import com.example.demo.feature.feed.domain.api.FeedRepository
import kotlinx.coroutines.flow.Flow

internal class PhotoFeedRepositoryImpl(
    private val photoDao: PhotoDao,
    private val photoApi: PhotoApi,
    private val photoMapper: PhotoResponseToPhotoMapper
) : FeedRepository<Photo> {

    override suspend fun fetch() {
        val photosResponse = photoApi.loadPhotos(limits = 5)
        photosResponse.forEach { photo ->
            photoDao.insert(photoMapper.map(photo))
        }
    }

    override suspend fun clear() {
        photoDao.clear()
    }

    override fun observe(): Flow<List<Photo>> =
        photoDao.observe()
}