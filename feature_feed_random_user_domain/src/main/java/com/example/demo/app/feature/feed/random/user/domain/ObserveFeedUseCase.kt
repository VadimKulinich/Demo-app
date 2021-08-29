package com.example.demo.app.feature.feed.random.user.domain

import com.example.demo.app.core.data.db.entity.user.UserWithPicture
import com.example.demo.app.core.domain.ObservableUseCase
import com.example.demo.app.feature.feed.random.user.domain.mapper.UserWithPictureToUserMapper
import com.example.demo.app.feature.feed.random.user.domain.model.User
import com.example.demo.feature.feed.domain.api.FeedRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class ObserveFeedUseCase(
    private val repository: FeedRepository<UserWithPicture>,
    private val mapper: UserWithPictureToUserMapper
) : ObservableUseCase<Unit, List<User>> {

    override fun invoke(param: Unit): Flow<List<User>> =
        repository.observe()
            .map { it.map(mapper::map) }
}