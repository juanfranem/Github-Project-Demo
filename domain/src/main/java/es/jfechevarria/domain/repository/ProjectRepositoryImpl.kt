package es.jfechevarria.domain.repository

import es.jfechevarria.domain.project.Project
import es.jfechevarria.domain.project.dataSource.ProjectDataSource
import es.jfechevarria.domain.project.repository.ProjectRepository
import es.jfechevarria.domain.project.repository.ProjectRequest

internal class ProjectRepositoryImpl(
    private val projectDataSource: ProjectDataSource
): ProjectRepository {
    override suspend fun searchProjectsByUser(request: ProjectRequest): List<Project> {
        return projectDataSource.searchProjectsByUser(request)
    }
}