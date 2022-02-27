package es.jfechevarria.domain.user.repository

import es.jfechevarria.domain.common.DomainRepository
import es.jfechevarria.domain.user.User

interface UserRepository: DomainRepository<User> {
    suspend fun searchByQuery(request: UserRequest): List<User>
}