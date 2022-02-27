package es.jfechevarria.domain.project.dataSource

import es.jfechevarria.domain.common.DomainDataSource
import es.jfechevarria.domain.project.Project
import es.jfechevarria.domain.project.repository.ProjectRequest

interface ProjectDataSource: DomainDataSource<Project> {
    suspend fun searchProjectsByUser(request: ProjectRequest): List<Project>
}