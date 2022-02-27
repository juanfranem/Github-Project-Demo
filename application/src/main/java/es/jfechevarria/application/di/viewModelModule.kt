package es.jfechevarria.application.di

import es.jfechevarria.application.viewmodels.ProjectViewModel
import es.jfechevarria.application.viewmodels.SearchHistoryViewModel
import es.jfechevarria.application.viewmodels.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ProjectViewModel(get()) }
    viewModel { SearchHistoryViewModel(get(), get(), get()) }
    viewModel { UserViewModel(get()) }
}