package es.jfechevarria.application.data.pageSource

import es.jfechevarria.application.core.BasePagingSource
import es.jfechevarria.application.data.usecase.SearchUserByQueryUseCase
import es.jfechevarria.domain.Result
import es.jfechevarria.domain.user.User
import es.jfechevarria.domain.user.repository.UserRequest
import kotlinx.coroutines.flow.first
import java.lang.Exception

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