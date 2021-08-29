package com.example.demo.app.core.domain

operator fun <T> UseCase<Unit, T>.invoke() = invoke(Unit)

operator fun <T> ObservableUseCase<Unit, T>.invoke() = invoke(Unit)