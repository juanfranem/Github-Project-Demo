package es.jfechevarria.application.ui.interfaces

import es.jfechevarria.domain.user.User

interface UserInteractor {
    fun onUserClick(user: User)
}