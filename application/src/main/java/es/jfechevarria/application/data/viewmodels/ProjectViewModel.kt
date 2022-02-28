package es.jfechevarria.application.data.viewmodels

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import es.jfechevarria.application.core.BaseViewModel
import es.jfechevarria.application.data.pageSource.ProjectsPageSource
import es.jfechevarria.application.data.usecase.SearchRepositoriesByUserUseCase
import es.jfechevarria.domain.user.User

class ProjectViewModel(
    private val user: User,
    private val searchRepositoriesByUserUseCase: SearchRepositoriesByUserUseCase
): BaseViewModel() {

    val repositoriesSource =  Pager(PagingConfig(pageSize = 10)) {
        ProjectsPageSource(user, searchRepositoriesByUserUseCase)
    }.liveData

}