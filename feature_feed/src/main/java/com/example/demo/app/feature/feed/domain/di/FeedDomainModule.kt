package com.example.demo.app.feature.feed.domain.di

import com.example.demo.app.core.domain.di.USE_CASE_SCOPE
import com.example.demo.app.feature.feed.domain.ClearCacheUseCse
import com.example.demo.app.feature.feed.domain.FetchFeedUseCase
import com.example.demo.app.feature.feed.domain.ObserveFeedUseCase
import com.example.demo.app.feature.feed.ui.mapper.UserWithPictureToUiUserMapper
import org.koin.dsl.module

val feedDomainModule = module {
    factory { FetchFeedUseCase(get(), get(USE_CASE_SCOPE)) }
    factory { ClearCacheUseCse(get(), get(USE_CASE_SCOPE)) }
    factory { ObserveFeedUseCase(get()) }
    factory { UserWithPictureToUiUserMapper(get()) }
}