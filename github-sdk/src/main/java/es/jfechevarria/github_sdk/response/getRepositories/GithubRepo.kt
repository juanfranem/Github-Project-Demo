package es.jfechevarria.github_sdk.response.getRepositories

import es.jfechevarria.github_sdk.common.BaseResponse

import kotlinx.serialization.Serializable

@Serializable
internal data class GithubRepo(
    val created_at: String,
    val description: String?,
    val fork: Boolean,
    val forks: Int?,
    val forks_count: Int?,
    val language: String?,
    val name: String,
    val `private`: Boolean,
    val updated_at: String,
    val html_url: String,
)

