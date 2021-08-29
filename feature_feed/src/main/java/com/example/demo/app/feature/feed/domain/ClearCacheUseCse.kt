package com.example.demo.app.feature.feed.domain

import com.example.demo.app.core.domain.UseCase
import kotlinx.coroutines.CoroutineScope

class ClearCacheUseCse(
    private val repository: FeedRepository,
    scope: CoroutineScope
) : UseCase<Unit, Unit>(scope) {

    override suspend fun execute(param: Unit) = repository.clear()
}