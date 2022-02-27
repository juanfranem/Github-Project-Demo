package es.jfechevarria.application.ui

sealed class AppState {
    object Loading: AppState()
    object Idle: AppState()
    class Error(message: String): AppState()
}