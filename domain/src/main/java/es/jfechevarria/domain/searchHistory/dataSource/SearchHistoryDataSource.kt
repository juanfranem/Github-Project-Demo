package es.jfechevarria.domain.searchHistory.dataSource

import es.jfechevarria.domain.common.DomainDataSource
import es.jfechevarria.domain.searchHistory.SearchHistory

interface SearchHistoryDataSource: DomainDataSource<SearchHistory> {
    suspend fun saveQuery(query: String)
    suspend fun deleteAllSearch()
    suspend fun getAllQueries(): List<SearchHistory>
}