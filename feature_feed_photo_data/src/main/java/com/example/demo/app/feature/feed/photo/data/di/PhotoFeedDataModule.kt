package com.example.demo.app.feature.feed.photo.data.di

import com.example.demo.app.core.data.db.entity.photo.Photo
import com.example.demo.app.feature.feed.photo.data.PhotoFeedRepositoryImpl
import com.example.demo.app.feature.feed.photo.data.mapper.PhotoResponseToPhotoMapper
import com.example.demo.app.feature.feed.photo.data.network.PhotoApi
import com.example.demo.feature.feed.domain.api.FeedRepository
import com.example.demo.feature.feed.domain.api.di.PHOTOS
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val SERVER_URL = "https://picsum.photos/v2/"

val feedPhotoDataModule = module {
    single<FeedRepository<Photo>>(PHOTOS) {
        PhotoFeedRepositoryImpl(get(), get(), get())
    }
    single(PHOTOS) {
        Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(get())
            .build()
    }
    single<PhotoApi> { get<Retrofit>(PHOTOS).create(PhotoApi::class.java) }
    factory { PhotoResponseToPhotoMapper() }
}