package com.example.demo.app.feature.feed.ui

import androidx.annotation.StringRes
import androidx.lifecycle.*
import com.example.demo.app.core.domain.ObservableUseCase
import com.example.demo.app.core.domain.UseCase
import com.example.demo.app.core.domain.invoke
import com.example.demo.app.core.ui.adapter.model.ListItem
import com.example.demo.app.feature.feed.R
import com.example.demo.app.feature.feed.photo.domain.model.Photo
import com.example.demo.app.feature.feed.random.user.domain.model.User
import com.example.demo.app.feature.feed.ui.mapper.PhotoToUiPhotoMapper
import com.example.demo.app.feature.feed.ui.mapper.UserToUiUserMapper
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class FeedViewModel(
    private val fetchFeedUseCase: UseCase<Unit, Unit>,
    private val clearCacheUseCse: UseCase<Unit, Unit>,
    private val observeUserFeedUseCase: ObservableUseCase<Unit, List<User>>,
    private val observePhotoFeedUseCase: ObservableUseCase<Unit, List<Photo>>,
    private val usersMapper: UserToUiUserMapper,
    private val photosMapper: PhotoToUiPhotoMapper,
) : ViewModel() {

    private val _fetchErrorMessage = MutableLiveData<@StringRes Int>()
    val fetchErrorMessage: LiveData<Int>
        get() = _fetchErrorMessage

    fun fetchFeed() {
        viewModelScope.launch {
            val fetchResult = fetchFeedUseCase().await()
            if (fetchResult.isFailure) {
                _fetchErrorMessage.value = R.string.fetch_feed_error
            }
        }
    }

    fun observeFeed(): LiveData<List<ListItem>> =
        observeUserFeedUseCase()
            .combine(observePhotoFeedUseCase()) { users, photos ->
                val uiUsers = users.map(usersMapper::map)
                val uiPhotos = photos.map(photosMapper::map)
                (uiUsers.plus(uiPhotos)).shuffled()
            }.asLiveData()

    fun clearCache() {
        viewModelScope.launch {
            clearCacheUseCse.invoke().await()
        }
    }
}