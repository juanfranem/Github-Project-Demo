package es.jfechevarria.domain

import es.jfechevarria.domain.project.repository.ProjectRepository
import es.jfechevarria.domain.repository.ProjectRepositoryImpl
import es.jfechevarria.domain.repository.SearchRepositoryImpl
import es.jfechevarria.domain.repository.UserRepositoryImpl
import es.jfechevarria.domain.searchHistory.repository.SearchHistoryRepository
import es.jfechevarria.domain.user.repository.UserRepository
import org.koin.dsl.module

val domainModule = module {
    factory<ProjectRepository> { ProjectRepositoryImpl(get()) }
    factory<SearchHistoryRepository> { SearchRepositoryImpl(get()) }
    factory<UserRepository> { UserRepositoryImpl(get()) }
}