package com.example.demo.app.feature.feed.photo.domain.di

import com.example.demo.app.core.domain.ObservableUseCase
import com.example.demo.app.core.domain.UseCase
import com.example.demo.app.core.domain.di.USE_CASE_SCOPE
import com.example.demo.app.feature.feed.photo.domain.ClearCacheUseCse
import com.example.demo.app.feature.feed.photo.domain.FetchFeedUseCase
import com.example.demo.app.feature.feed.photo.domain.ObserveFeedUseCase
import com.example.demo.app.feature.feed.photo.domain.mapper.DbPhotoToPhotoMapper
import com.example.demo.app.feature.feed.photo.domain.model.Photo
import com.example.demo.feature.feed.domain.api.di.PHOTOS
import com.example.demo.feature.feed.domain.api.di.PHOTOS_CLEAR
import com.example.demo.feature.feed.domain.api.di.PHOTOS_FETCH
import org.koin.dsl.module

val feedPhotoDomainModule = module {
    factory<UseCase<Unit, Unit>>(PHOTOS_FETCH) { FetchFeedUseCase(get(), get(USE_CASE_SCOPE)) }
    factory<UseCase<Unit, Unit>>(PHOTOS_CLEAR) { ClearCacheUseCse(get(), get(USE_CASE_SCOPE)) }
    factory<ObservableUseCase<Unit, List<Photo>>>(PHOTOS) { ObserveFeedUseCase(get(PHOTOS), get()) }
    factory { DbPhotoToPhotoMapper() }
}