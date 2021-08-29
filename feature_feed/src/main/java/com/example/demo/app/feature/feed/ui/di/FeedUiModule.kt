package com.example.demo.app.feature.feed.ui.di

import com.example.demo.app.feature.feed.ui.FeedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val feedUiModule = module {
    viewModel { FeedViewModel(get(), get(), get(), get()) }
}