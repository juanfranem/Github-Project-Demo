package es.jfechevarria.domain.user.repository

class UserRequest(val query: String) {
    var page: Int = 1
    var totalItems: Int = 10
}