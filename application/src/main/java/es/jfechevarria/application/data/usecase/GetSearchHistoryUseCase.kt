package es.jfechevarria.application.data.usecase

import es.jfechevarria.application.core.BaseUseCase
import es.jfechevarria.domain.Result
import es.jfechevarria.domain.searchHistory.SearchHistory
import es.jfechevarria.domain.searchHistory.repository.SearchHistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSearchHistoryUseCase(
    private val historyRepository: SearchHistoryRepository
): BaseUseCase<Unit, List<SearchHistory>>() {
    override fun execute(parameters: Unit): Flow<Result<List<SearchHistory>>> = flow {
        emit(Result.Loading)
        emit(Result.Success(historyRepository.getAllQueries()))
    }
}