package com.example.demo.app.feature.feed.random.user.domain.model

data class User(
    val id: String,
    val title: String,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val street: String,
    val number: String,
    val city: String,
    val postcode: String,
    val url: String
)