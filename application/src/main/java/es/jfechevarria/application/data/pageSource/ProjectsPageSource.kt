package es.jfechevarria.application.data.pageSource

import es.jfechevarria.application.core.BasePagingSource
import es.jfechevarria.application.data.usecase.SearchRepositoriesByUserUseCase
import es.jfechevarria.domain.Result
import es.jfechevarria.domain.project.Project
import es.jfechevarria.domain.project.repository.ProjectRequest
import es.jfechevarria.domain.user.User
import kotlinx.coroutines.flow.first
import java.lang.Exception

class ProjectsPageSource(
    private val user: User,
    private val searchRepositories: SearchRepositoriesByUserUseCase
): BasePagingSource<Project>() {
    override suspend fun getItems(params: Int): List<Project> {
        try {
            return (searchRepositories(ProjectRequest(user.userName).apply {
                page = params
            }).first { it is Result.Success } as Result.Success).data
        } catch (e: Exception) {
            throw e
        }
    }
}