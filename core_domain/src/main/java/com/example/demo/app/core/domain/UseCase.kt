package com.example.demo.app.core.domain

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async

abstract class UseCase<In, Out>(private val useCaseScope: CoroutineScope) {

    protected abstract suspend fun execute(param: In): Out

    operator fun invoke(param: In): Deferred<Result<Out>> =
        useCaseScope.async {
            try {
                Result.success(execute(param))
            } catch (t: Throwable) {
                Result.failure(t)
            }
        }
}