package com.example.demo.app.feature.feed.aggregated.domain

import com.example.demo.app.core.data.db.entity.photo.Photo
import com.example.demo.app.core.data.db.entity.user.User
import com.example.demo.app.core.domain.UseCase
import com.example.demo.feature.feed.domain.api.FeedRepository
import kotlinx.coroutines.CoroutineScope

internal class FetchFeedUseCase(
    private val photoRepository: FeedRepository<Photo>,
    private val userRepository: FeedRepository<User>,
    scope: CoroutineScope
) : UseCase<Unit, Unit>(scope) {

    override suspend fun execute(param: Unit) {
        photoRepository.fetch()
        userRepository.fetch()
    }
}