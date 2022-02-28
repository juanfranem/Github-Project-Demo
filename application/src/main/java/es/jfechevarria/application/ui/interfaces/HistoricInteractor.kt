package es.jfechevarria.application.ui.interfaces

import es.jfechevarria.domain.searchHistory.SearchHistory

interface HistoricInteractor {
    fun onSearchHistoricClick(searchHistory: SearchHistory)
}