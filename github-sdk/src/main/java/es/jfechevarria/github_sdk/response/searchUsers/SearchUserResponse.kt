package es.jfechevarria.github_sdk.response.searchUsers

import es.jfechevarria.github_sdk.common.BaseResponse
import kotlinx.serialization.Serializable

@Serializable
internal data class SearchUserResponse(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: List<GithubUser>
): BaseResponse()