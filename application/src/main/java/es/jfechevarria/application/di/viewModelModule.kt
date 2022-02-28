package es.jfechevarria.application.di

import es.jfechevarria.application.data.viewmodels.ProjectViewModel
import es.jfechevarria.application.data.viewmodels.SearchHistoryViewModel
import es.jfechevarria.application.data.viewmodels.UserViewModel
import es.jfechevarria.domain.user.User
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { (user: User) -> ProjectViewModel(user, get()) }
    viewModel { SearchHistoryViewModel(get(), get(), get()) }
    viewModel { UserViewModel(get()) }
}