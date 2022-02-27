package es.jfechevarria.domain.user.dataSource

import es.jfechevarria.domain.common.DomainDataSource
import es.jfechevarria.domain.user.User
import es.jfechevarria.domain.user.repository.UserRequest

interface UserDataSource: DomainDataSource<User> {
    suspend fun searchByQuery(request: UserRequest): List<User>
}