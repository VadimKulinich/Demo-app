package com.example.demo.app.feature.feed.data.di

import com.example.demo.app.feature.feed.data.FeedRepositoryImpl
import com.example.demo.app.feature.feed.data.mapper.UserResponseToAddressMapper
import com.example.demo.app.feature.feed.data.mapper.UserResponseToPictureMapper
import com.example.demo.app.feature.feed.data.mapper.UserResponseToUserMapper
import com.example.demo.app.feature.feed.data.network.UserApi
import com.example.demo.app.feature.feed.domain.FeedRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val feedDataModule = module {
    single<FeedRepository> { FeedRepositoryImpl(get(), get(), get(), get(), get(), get()) }
    single<UserApi> { get<Retrofit>().create(UserApi::class.java) }
    factory { UserResponseToUserMapper() }
    factory { UserResponseToAddressMapper() }
    factory { UserResponseToPictureMapper() }
}