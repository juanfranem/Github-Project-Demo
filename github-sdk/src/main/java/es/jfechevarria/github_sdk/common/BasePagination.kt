package es.jfechevarria.github_sdk.common

internal class BasePagination(
    var sort: String? = null,
    var order: String? = null,
    var perPage: Int = 10,
    var page: Int = 1
)