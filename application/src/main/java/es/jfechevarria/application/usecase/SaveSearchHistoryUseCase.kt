package es.jfechevarria.application.usecase

import es.jfechevarria.application.core.BaseUseCase
import es.jfechevarria.domain.Result
import es.jfechevarria.domain.searchHistory.repository.SearchHistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SaveSearchHistoryUseCase(
    private val historyRepository: SearchHistoryRepository
): BaseUseCase<String, Unit>() {
    override fun execute(parameters: String): Flow<Result<Unit>> = flow {
        emit(Result.Loading)
        historyRepository.saveQuery(parameters)
        emit(Result.Success(Unit))
    }
}