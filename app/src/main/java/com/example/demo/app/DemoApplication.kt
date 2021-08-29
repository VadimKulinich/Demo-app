package com.example.demo.app

import android.app.Application
import com.example.demo.app.core.data.di.dataModule
import com.example.demo.app.core.domain.di.domainModule
import com.example.demo.app.feature.feed.data.di.feedDataModule
import com.example.demo.app.feature.feed.domain.di.feedDomainModule
import com.example.demo.app.feature.feed.ui.di.feedUiModule
import com.example.demo.app.uilts.di.utilsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class DemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            loadKoinModules(listOf(dataModule, domainModule, utilsModule))
            loadKoinModules(listOf(feedDataModule, feedDomainModule, feedUiModule))
        }
    }
}