package es.jfechevarria.domain.searchHistory.repository

import es.jfechevarria.domain.common.DomainRepository
import es.jfechevarria.domain.searchHistory.SearchHistory

interface SearchHistoryRepository: DomainRepository<SearchHistory> {
    suspend fun saveQuery(query: String)
    suspend fun deleteAllSearch()
    suspend fun getAllQueries(): List<SearchHistory>
}