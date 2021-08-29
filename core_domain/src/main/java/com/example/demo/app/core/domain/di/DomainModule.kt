package com.example.demo.app.core.domain.di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

val USE_CASE_SCOPE = named("useCaseScope")

val domainModule = module {
    single(USE_CASE_SCOPE) { CoroutineScope(Dispatchers.IO) }
}