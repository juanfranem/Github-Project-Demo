package es.jfechevarria.github_sdk.request.getRepositories

import es.jfechevarria.domain.project.Project
import es.jfechevarria.domain.project.dataSource.ProjectDataSource
import es.jfechevarria.domain.project.repository.ProjectRequest
import es.jfechevarria.github_sdk.common.BaseResponseList
import es.jfechevarria.github_sdk.response.getRepositories.GithubRepo
import io.ktor.client.*
import io.ktor.client.request.*

internal class ProjectsDataSourceImpl(private val httpRequest: GetRepositoriesRequest): ProjectDataSource {
    override suspend fun searchProjectsByUser(request: ProjectRequest): List<Project> {
        httpRequest.pagination.apply {
            page = request.page
            perPage = request.totalItems
        }
        httpRequest.userName = request.user
        return httpRequest.execute<BaseResponseList<GithubRepo>>().map {
            Project(
                name = it.name,
                private = it.private,
                externalUrl = it.url,
                description = it.description,
                forked = it.fork,
                forksCount = it.forks_count,
                createdDate = it.created_at,
                updatedDate = it.updated_at,
                language = it.language
            )
        }

    }
}