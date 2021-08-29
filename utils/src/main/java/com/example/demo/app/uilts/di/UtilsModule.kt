package com.example.demo.app.uilts.di

import com.example.demo.app.uilts.provider.ResourceStringProvider
import com.example.demo.app.uilts.provider.StringProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val utilsModule = module {
    single<StringProvider> { ResourceStringProvider(androidContext().resources) }
}