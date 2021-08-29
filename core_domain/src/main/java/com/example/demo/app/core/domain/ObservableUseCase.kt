package com.example.demo.app.core.domain

import kotlinx.coroutines.flow.Flow

interface ObservableUseCase<In, Out> {

    fun invoke(param: In): Flow<Out>
}