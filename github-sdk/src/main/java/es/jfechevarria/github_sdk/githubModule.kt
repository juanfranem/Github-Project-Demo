package es.jfechevarria.github_sdk

import es.jfechevarria.domain.project.dataSource.ProjectDataSource
import es.jfechevarria.domain.user.dataSource.UserDataSource
import es.jfechevarria.github_sdk.request.getRepositories.GetRepositoriesRequest
import es.jfechevarria.github_sdk.request.getRepositories.ProjectsDataSourceImpl
import es.jfechevarria.github_sdk.request.searchUsers.SearchUserRequest
import es.jfechevarria.github_sdk.request.searchUsers.SearchUsersDataSourceImpl
import io.ktor.client.*
import org.koin.dsl.module

val githubModule = module {
    factory<ProjectDataSource> { ProjectsDataSourceImpl(GetRepositoriesRequest()) }
    factory<UserDataSource> { SearchUsersDataSourceImpl(SearchUserRequest()) }
}