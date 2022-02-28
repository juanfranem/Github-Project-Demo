package es.jfechevarria.application.data.usecase

import es.jfechevarria.application.core.BaseUseCase
import es.jfechevarria.domain.Result
import es.jfechevarria.domain.user.User
import es.jfechevarria.domain.user.repository.UserRepository
import es.jfechevarria.domain.user.repository.UserRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchUserByQueryUseCase(
    private val userRepository: UserRepository
): BaseUseCase<UserRequest, List<User>>() {
    override fun execute(parameters: UserRequest): Flow<Result<List<User>>> = flow {
        emit(Result.Loading)
        emit(Result.Success(userRepository.searchByQuery(parameters)))
    }
}