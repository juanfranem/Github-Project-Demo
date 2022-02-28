package es.jfechevarria.application.di

import es.jfechevarria.application.data.usecase.*
import org.koin.dsl.module

val usecaseModule = module {
    factory { DeleteSearchHistoryUseCase(get()) }
    factory { GetSearchHistoryUseCase(get()) }
    factory { SaveSearchHistoryUseCase(get()) }
    factory { SearchRepositoriesByUserUseCase(get()) }
    factory { SearchUserByQueryUseCase(get()) }
}