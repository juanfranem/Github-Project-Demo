package es.jfechevarria.application.data.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import es.jfechevarria.application.core.BaseViewModel
import es.jfechevarria.application.data.pageSource.UserPageSource
import es.jfechevarria.application.data.usecase.SearchUserByQueryUseCase

class UserViewModel(
    private val searchUserByQueryUseCase: SearchUserByQueryUseCase
): BaseViewModel() {

    private val mutableQuery: MutableLiveData<String> = MutableLiveData()
    val pageSource = Transformations.switchMap(mutableQuery) {
        Pager(PagingConfig(pageSize = 10)) {
            UserPageSource(searchUserByQueryUseCase, it)
        }.liveData
    }

    fun setQuery(query: String) {
        mutableQuery.postValue(query)
    }
}