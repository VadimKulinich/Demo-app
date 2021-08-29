package com.example.demo.app.feature.feed.random.user.domain.di

import com.example.demo.app.core.domain.ObservableUseCase
import com.example.demo.app.core.domain.UseCase
import com.example.demo.app.core.domain.di.USE_CASE_SCOPE
import com.example.demo.app.feature.feed.random.user.domain.ClearCacheUseCse
import com.example.demo.app.feature.feed.random.user.domain.FetchFeedUseCase
import com.example.demo.app.feature.feed.random.user.domain.ObserveFeedUseCase
import com.example.demo.app.feature.feed.random.user.domain.mapper.UserWithPictureToUserMapper
import com.example.demo.app.feature.feed.random.user.domain.model.User
import com.example.demo.feature.feed.domain.api.di.USERS
import com.example.demo.feature.feed.domain.api.di.USERS_CLEAR
import com.example.demo.feature.feed.domain.api.di.USERS_FETCH
import org.koin.core.qualifier.named
import org.koin.dsl.module

val feedRandomUserDomainModule = module {
    factory<UseCase<Unit, Unit>>(USERS_FETCH) { FetchFeedUseCase(get(USERS), get(USE_CASE_SCOPE)) }
    factory<UseCase<Unit, Unit>>(USERS_CLEAR) { ClearCacheUseCse(get(USERS), get(USE_CASE_SCOPE)) }
    factory<ObservableUseCase<Unit, List<User>>>(USERS) { ObserveFeedUseCase(get(USERS), get()) }
    factory { UserWithPictureToUserMapper() }
}