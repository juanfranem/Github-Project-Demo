package es.jfechevarria.github_sdk.request.getRepositories

import es.jfechevarria.github_sdk.common.BaseRequest
import es.jfechevarria.github_sdk.common.BaseResponse
import es.jfechevarria.github_sdk.common.BaseResponseList
import es.jfechevarria.github_sdk.request.getRepositories.HttpConstants.PATH
import es.jfechevarria.github_sdk.response.getRepositories.GithubRepo

internal class GetRepositoriesRequest(): BaseRequest<BaseResponseList<GithubRepo>>() {
    var userName: String = ""
    override val path: String = PATH.format(userName)
}