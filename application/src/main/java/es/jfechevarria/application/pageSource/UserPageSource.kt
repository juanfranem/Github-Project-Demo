package es.jfechevarria.application.pageSource

import es.jfechevarria.application.core.BasePagingSource
import es.jfechevarria.application.usecase.SearchUserByQueryUseCase
import es.jfechevarria.domain.Result
import es.jfechevarria.domain.user.User
import es.jfechevarria.domain.user.repository.UserRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import java.lang.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class UserPageSource(
    private val searchUserByQueryUseCase: SearchUserByQueryUseCase,
    private val query: String
): BasePagingSource<User>() {
    override suspend fun getItems(params: Int): List<User> {
        try {
            return (searchUserByQueryUseCase(UserRequest(query).apply {
                page = params
            }).first { it is Result.Success } as Result.Success).data
        } catch (e: Exception) {
            throw e
        }
    }
}