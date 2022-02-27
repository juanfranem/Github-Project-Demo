package es.jfechevarria.domain.repository

import es.jfechevarria.domain.user.User
import es.jfechevarria.domain.user.dataSource.UserDataSource
import es.jfechevarria.domain.user.repository.UserRepository
import es.jfechevarria.domain.user.repository.UserRequest

class UserRepositoryImpl(
    private val userDataSource: UserDataSource
): UserRepository {
    override suspend fun searchByQuery(request: UserRequest): List<User> {
        return userDataSource.searchByQuery(request)
    }
}