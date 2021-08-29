package com.example.demo.app.feature.feed.domain

import com.example.demo.app.core.data.db.entity.UserWithPicture
import com.example.demo.app.core.domain.ObservableUseCase
import kotlinx.coroutines.flow.Flow

class ObserveFeedUseCase(
    private val repository: FeedRepository
) : ObservableUseCase<Unit, List<UserWithPicture>> {

    override fun invoke(param: Unit): Flow<List<UserWithPicture>> =
        repository.observeFeed()
}