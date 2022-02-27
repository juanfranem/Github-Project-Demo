package es.jfechevarria.application.viewmodels

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import es.jfechevarria.application.core.BaseViewModel
import es.jfechevarria.application.pageSource.UserPageSource
import es.jfechevarria.application.usecase.SearchUserByQueryUseCase

class UserViewModel(
    private val searchUserByQueryUseCase: SearchUserByQueryUseCase
): BaseViewModel() {

    fun getUserSearchData(query: String) = Pager(PagingConfig(pageSize = 10)) {
        UserPageSource(searchUserByQueryUseCase, query)
    }.liveData

}