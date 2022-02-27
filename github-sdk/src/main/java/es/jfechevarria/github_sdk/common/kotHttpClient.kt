package es.jfechevarria.github_sdk.common

import es.jfechevarria.github_sdk.response.searchUsers.GithubUser
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.modules.SerializersModule

private const val TIME_OUT: Long = 15_000

internal fun getClient() = HttpClient(Android) {
    install(JsonFeature) {
        serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true

        })
    }

    install(HttpTimeout) {
        requestTimeoutMillis = TIME_OUT
        socketTimeoutMillis = TIME_OUT
        connectTimeoutMillis = TIME_OUT

    }

    install(Logging) {
        logger = object: Logger {
            override fun log(message: String) {
                println("Http message: $message")
            }
        }
        level = LogLevel.ALL
    }

    install(ResponseObserver) {
        onResponse { response ->
            println("Http status: ${response.status.value}")
        }
    }

    install(DefaultRequest) {
        url.protocol = URLProtocol.HTTPS
        url.host = Secrets().find(Secrets.URL_BASE) ?: ""
        header(HttpHeaders.ContentType, ContentType.Application.Json)
        header(HttpHeaders.Accept, ContentType.Application.Json)
        Secrets().find(Secrets.API_KEY)?.let {

            header(HttpHeaders.Authorization, "token $it")
        }
    }

}