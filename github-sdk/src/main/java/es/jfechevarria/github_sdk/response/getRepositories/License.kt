package es.jfechevarria.github_sdk.response.getRepositories
import kotlinx.serialization.Serializable

@Serializable
internal data class License(
    val key: String,
    val name: String,
    val node_id: String,
    val spdx_id: String,
    val url: String
)