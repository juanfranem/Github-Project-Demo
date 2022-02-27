package es.jfechevarria.domain.repository

import es.jfechevarria.domain.searchHistory.SearchHistory
import es.jfechevarria.domain.searchHistory.dataSource.SearchHistoryDataSource
import es.jfechevarria.domain.searchHistory.repository.SearchHistoryRepository

internal class SearchRepositoryImpl(
    private val searchHistoryDataSource: SearchHistoryDataSource
): SearchHistoryRepository {
    override suspend fun saveQuery(query: String) {
        searchHistoryDataSource.saveQuery(query)
    }

    override suspend fun deleteAllSearch() {
        searchHistoryDataSource.deleteAllSearch()
    }

    override suspend fun getAllQueries(): List<SearchHistory> {
        return searchHistoryDataSource.getAllQueries()
    }
}