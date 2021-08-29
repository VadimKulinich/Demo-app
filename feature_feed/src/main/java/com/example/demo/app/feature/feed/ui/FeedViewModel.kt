package com.example.demo.app.feature.feed.ui

import androidx.annotation.StringRes
import androidx.lifecycle.*
import com.example.demo.app.core.domain.invoke
import com.example.demo.app.core.ui.adapter.model.ListItem
import com.example.demo.app.feature.feed.R
import com.example.demo.app.feature.feed.domain.ClearCacheUseCse
import com.example.demo.app.feature.feed.domain.FetchFeedUseCase
import com.example.demo.app.feature.feed.domain.ObserveFeedUseCase
import com.example.demo.app.feature.feed.ui.mapper.UserWithPictureToUiUserMapper
import com.example.demo.app.feature.feed.ui.model.UiUser
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class FeedViewModel(
    private val fetchFeedUseCase: FetchFeedUseCase,
    private val observeFeedUseCase: ObserveFeedUseCase,
    private val clearCacheUseCse: ClearCacheUseCse,
    private val mapper: UserWithPictureToUiUserMapper
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
        observeFeedUseCase()
            .map { it.map(mapper::map) }
            .asLiveData()

    fun clearCache() {
        viewModelScope.launch {
            clearCacheUseCse.invoke().await()
        }
    }
}