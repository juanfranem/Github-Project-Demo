package es.jfechevarria.application.viewmodels

import androidx.lifecycle.ViewModel
import es.jfechevarria.application.core.BaseViewModel
import es.jfechevarria.application.usecase.SearchRepositoriesByUserUseCase

class ProjectViewModel(
    private val searchRepositoriesByUserUseCase: SearchRepositoriesByUserUseCase
): BaseViewModel() {
}