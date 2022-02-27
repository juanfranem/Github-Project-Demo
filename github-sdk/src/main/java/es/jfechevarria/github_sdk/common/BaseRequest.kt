package es.jfechevarria.github_sdk.common

import io.ktor.client.request.*

internal abstract class BaseRequest<T: BaseResponse> {
    abstract val path: String
    private val params: MutableMap<String, Any> = mutableMapOf()
    private val client = getClient()
    fun addParam(name: String, value: Any) {
        params[name] = value
    }

    fun removeParam(name: String) {
        params.remove(name)
    }

    open val pagination: BasePagination = BasePagination()


    suspend inline fun <reified T: BaseResponse> execute(): T {
        return client.get<T>(path) {
            params.forEach { (s, any) ->
                this.parameter(s, any)
            }
            pagination.order?.let {
                this.parameter("order", it)
            }
            pagination.page.let {
                this.parameter("page", it)
            }
            pagination.perPage.let {
                this.parameter("per_page", it)
            }
            pagination.sort.let {
                this.parameter("sort", it)
            }
        }
    }
}