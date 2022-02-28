package es.jfechevarria.application.data.usecase

import es.jfechevarria.application.core.BaseUseCase
import es.jfechevarria.domain.Result
import es.jfechevarria.domain.searchHistory.repository.SearchHistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DeleteSearchHistoryUseCase(
    private val historyRepository: SearchHistoryRepository
): BaseUseCase<Unit, Unit>() {
    override fun execute(parameters: Unit): Flow<Result<Unit>> = flow {
        emit(Result.Loading)
        historyRepository.deleteAllSearch()
        emit(Result.Success(Unit))
    }
}