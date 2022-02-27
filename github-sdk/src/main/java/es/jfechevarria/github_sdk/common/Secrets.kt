package es.jfechevarria.github_sdk.common

import java.util.*

internal class Secrets {

    companion object {
        const val API_KEY = "API_KEY"
        const val URL_BASE = "URL_BASE"
    }
    private val versionProperties = Properties()
    init {
        val versionPropertiesFile = this.javaClass.getResourceAsStream("/secrets.properties")
        versionProperties.load(versionPropertiesFile)
    }

    fun find(name: String): String? {
        return versionProperties.getProperty(name) ?: null
    }
}