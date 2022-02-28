package es.jfechevarria.application.data.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import es.jfechevarria.application.core.BaseViewModel
import es.jfechevarria.application.data.usecase.DeleteSearchHistoryUseCase
import es.jfechevarria.application.data.usecase.GetSearchHistoryUseCase
import es.jfechevarria.application.data.usecase.SaveSearchHistoryUseCase
import es.jfechevarria.domain.Result
import es.jfechevarria.domain.searchHistory.SearchHistory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchHistoryViewModel(
    private val deleteSearchHistoryUseCase: DeleteSearchHistoryUseCase,
    private val getSearchHistoryUseCase: GetSearchHistoryUseCase,
    private val saveSearchHistoryUseCase: SaveSearchHistoryUseCase
): BaseViewModel() {

    private val mutableLiveData = MutableLiveData<List<SearchHistory>>()
    val searchHistoryData: LiveData<List<SearchHistory>> by lazy {
        obtainSearchHistory()
        mutableLiveData
    }

    fun saveSearch(query: String) {
        viewModelScope.launch {
            saveSearchHistoryUseCase(query).collect {
                validateState(it)
            }
        }
    }

    fun deleteAllHistory() {
        viewModelScope.launch {
            deleteSearchHistoryUseCase(Unit).collect {
                validateState(it)
            }
        }
    }

    fun obtainSearchHistory() {
        viewModelScope.launch {
            getSearchHistoryUseCase(Unit).collect {
                validateState(it)
                when (it) {
                    is Result.Success -> {
                        mutableLiveData.postValue(it.data!!)
                    }
                }
            }
        }
    }

}