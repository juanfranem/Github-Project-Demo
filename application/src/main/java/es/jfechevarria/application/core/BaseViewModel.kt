package es.jfechevarria.application.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.jfechevarria.application.ui.AppState
import es.jfechevarria.domain.Result

abstract class BaseViewModel: ViewModel() {

    private val mutableState = MutableLiveData<AppState>()
    val state: LiveData<AppState> = mutableState

    fun setState(appState: AppState) {
        mutableState.postValue(appState)
    }

    fun validateState(result: Result<Any>) {
        when (result) {
            is Result.Loading -> mutableState.postValue(AppState.Loading)
            is Result.Success -> mutableState.postValue(AppState.Idle)
            is Result.Error -> mutableState.postValue(AppState.Error(result.exception.message ?: ""))
        }
    }
}