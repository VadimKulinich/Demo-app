package com.example.demo.app.feature.feed.photo.domain

import com.example.demo.app.core.data.db.entity.photo.Photo as DbPhoto
import com.example.demo.app.core.domain.ObservableUseCase
import com.example.demo.app.feature.feed.photo.domain.mapper.DbPhotoToPhotoMapper
import com.example.demo.app.feature.feed.photo.domain.model.Photo
import com.example.demo.feature.feed.domain.api.FeedRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class ObserveFeedUseCase(
    private val repository: FeedRepository<DbPhoto>,
    private val mapper: DbPhotoToPhotoMapper
) : ObservableUseCase<Unit, List<Photo>> {

    override fun invoke(param: Unit): Flow<List<Photo>> =
        repository.observe()
            .map { it.map(mapper::map) }
}