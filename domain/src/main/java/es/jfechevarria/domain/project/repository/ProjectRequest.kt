package es.jfechevarria.domain.project.repository


class ProjectRequest(val user: String) {
    var page: Int = 1
    var totalItems: Int = 10
}