package es.jfechevarria.room.datasource

import es.jfechevarria.domain.searchHistory.SearchHistory
import es.jfechevarria.domain.searchHistory.dataSource.SearchHistoryDataSource
import es.jfechevarria.room.dao.SearchHistoryDao
import es.jfechevarria.room.entity.SearchHistoryEntity

internal class SearchHistoryDataSourceImpl(
    private val searchHistoryDao: SearchHistoryDao
): SearchHistoryDataSource {
    override suspend fun saveQuery(query: String) {
        searchHistoryDao.insert(SearchHistoryEntity(query = query))
    }

    override suspend fun deleteAllSearch() {
        searchHistoryDao.deleteAll()
    }

    override suspend fun getAllQueries(): List<SearchHistory> {
        return searchHistoryDao.getSearchHistory().map {
            SearchHistory(
                query = it.query,
                createdOn = it.createdAt.time
            )
        }
    }
}