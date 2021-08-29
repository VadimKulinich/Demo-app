package com.example.demo.app.feature.feed.ui.di

import com.example.demo.app.feature.feed.ui.FeedViewModel
import com.example.demo.app.feature.feed.ui.mapper.PhotoToUiPhotoMapper
import com.example.demo.app.feature.feed.ui.mapper.UserToUiUserMapper
import com.example.demo.feature.feed.domain.api.di.AGGREGATED_CLEAR
import com.example.demo.feature.feed.domain.api.di.AGGREGATED_FETCH
import com.example.demo.feature.feed.domain.api.di.PHOTOS
import com.example.demo.feature.feed.domain.api.di.USERS
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val feedUiModule = module {
    viewModel {
        FeedViewModel(
            get(AGGREGATED_FETCH), get(AGGREGATED_CLEAR),
            get(USERS), get(PHOTOS),
            get(), get()
        )
    }
    factory { UserToUiUserMapper(get()) }
    factory { PhotoToUiPhotoMapper() }
}