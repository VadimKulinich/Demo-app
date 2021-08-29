package com.example.demo.app.feature.feed.random.user.domain

import com.example.demo.app.core.data.db.entity.user.UserWithPicture
import com.example.demo.app.core.domain.UseCase
import com.example.demo.feature.feed.domain.api.FeedRepository
import kotlinx.coroutines.CoroutineScope

internal class ClearCacheUseCse(
    private val repository: FeedRepository<UserWithPicture>,
    scope: CoroutineScope
) : UseCase<Unit, Unit>(scope) {

    override suspend fun execute(param: Unit) = repository.clear()
}