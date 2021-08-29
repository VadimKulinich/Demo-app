package com.example.demo.app.feature.feed.random.user.data.di

import com.example.demo.app.core.data.db.entity.user.UserWithPicture
import com.example.demo.app.feature.feed.random.user.data.UsersFeedRepositoryImpl
import com.example.demo.app.feature.feed.random.user.data.mapper.UserResponseToAddressMapper
import com.example.demo.app.feature.feed.random.user.data.mapper.UserResponseToPictureMapper
import com.example.demo.app.feature.feed.random.user.data.mapper.UserResponseToUserMapper
import com.example.demo.app.feature.feed.random.user.data.network.UserApi
import com.example.demo.feature.feed.domain.api.FeedRepository
import com.example.demo.feature.feed.domain.api.di.USERS
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val SERVER_URL = "https://randomuser.me/"

val feedRandomUserDataModule = module {
    single<FeedRepository<UserWithPicture>>(USERS) {
        UsersFeedRepositoryImpl(get(), get(), get(), get(), get(), get())
    }
    single<UserApi> { get<Retrofit>(USERS).create(UserApi::class.java) }
    single(USERS) {
        Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(get())
            .build()
    }
    factory { UserResponseToUserMapper() }
    factory { UserResponseToAddressMapper() }
    factory { UserResponseToPictureMapper() }
}