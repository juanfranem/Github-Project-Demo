package es.jfechevarria.application.data.usecase

import es.jfechevarria.application.core.BaseUseCase
import es.jfechevarria.domain.Result
import es.jfechevarria.domain.project.Project
import es.jfechevarria.domain.project.repository.ProjectRepository
import es.jfechevarria.domain.project.repository.ProjectRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRepositoriesByUserUseCase(
    private val projectRepository: ProjectRepository
): BaseUseCase<ProjectRequest, List<Project>>() {
    override fun execute(parameters: ProjectRequest): Flow<Result<List<Project>>> = flow {
        emit(Result.Loading)
        emit(Result.Success(projectRepository.searchProjectsByUser(parameters)))
    }
}