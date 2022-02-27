package es.jfechevarria.github_sdk.request.searchUsers

import es.jfechevarria.domain.user.User
import es.jfechevarria.domain.user.dataSource.UserDataSource
import es.jfechevarria.domain.user.repository.UserRequest
import es.jfechevarria.github_sdk.response.searchUsers.SearchUserResponse
import io.ktor.client.*
import io.ktor.client.request.*

internal class SearchUsersDataSourceImpl(
    private val userRequest: SearchUserRequest
): UserDataSource {
    override suspend fun searchByQuery(request: UserRequest): List<User> {
        userRequest.pagination.apply {
            page = request.page
            perPage = request.totalItems
        }
        userRequest.userName = request.query
        return userRequest.execute<SearchUserResponse>().items.map {
            User(
                image = it.avatar_url,
                userName = it.login,
                externalUrl = it.url
            )
        }
    }
}