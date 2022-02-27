package es.jfechevarria.github_sdk.request.searchUsers

import es.jfechevarria.github_sdk.common.BaseRequest
import es.jfechevarria.github_sdk.response.searchUsers.SearchUserResponse

internal class SearchUserRequest() : BaseRequest<SearchUserResponse>() {
    var userName: String = ""
        set(value) {
            addParam("q", "$value in:name")
            field = value
        }

    override val path: String = HttpConstants.PATH
}