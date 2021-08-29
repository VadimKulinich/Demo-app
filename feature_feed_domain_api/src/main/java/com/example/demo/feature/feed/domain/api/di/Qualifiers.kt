package com.example.demo.feature.feed.domain.api.di

import org.koin.core.qualifier.named

val USERS = named("users_feed")
val USERS_FETCH = named("users_feed_fetch")
val USERS_CLEAR = named("users_feed_clear")

val PHOTOS = named("photo_feed")
val PHOTOS_FETCH = named("photo_feed_fetch")
val PHOTOS_CLEAR = named("photo_feed_clear")

val AGGREGATED_FETCH = named("aggregated_feed_fetch")
val AGGREGATED_CLEAR = named("aggregated_feed_clear")
