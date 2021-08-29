package com.example.demo.app.feature.feed.aggregated.domain.di

import com.example.demo.app.core.domain.UseCase
import com.example.demo.app.core.domain.di.USE_CASE_SCOPE
import com.example.demo.app.feature.feed.aggregated.domain.ClearCacheUseCse
import com.example.demo.app.feature.feed.aggregated.domain.FetchFeedUseCase
import com.example.demo.feature.feed.domain.api.di.AGGREGATED_CLEAR
import com.example.demo.feature.feed.domain.api.di.AGGREGATED_FETCH
import com.example.demo.feature.feed.domain.api.di.PHOTOS
import com.example.demo.feature.feed.domain.api.di.USERS
import org.koin.dsl.module

val feedAggregatedDomainModule = module {
    factory<UseCase<Unit, Unit>>(AGGREGATED_FETCH) {
        FetchFeedUseCase(get(PHOTOS), get(USERS), get(USE_CASE_SCOPE))
    }
    factory<UseCase<Unit, Unit>>(AGGREGATED_CLEAR) {
        ClearCacheUseCse(get(PHOTOS), get(USERS), get(USE_CASE_SCOPE))
    }
}