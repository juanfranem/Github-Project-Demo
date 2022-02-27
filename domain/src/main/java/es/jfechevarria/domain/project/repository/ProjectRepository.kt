package es.jfechevarria.domain.project.repository

import es.jfechevarria.domain.common.DomainRepository
import es.jfechevarria.domain.project.Project

interface ProjectRepository: DomainRepository<Project> {
    suspend fun searchProjectsByUser(request: ProjectRequest): List<Project>
}