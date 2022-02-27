package es.jfechevarria.application

import android.app.Application
import es.jfechevarria.application.di.usecaseModule
import es.jfechevarria.application.di.viewModelModule
import es.jfechevarria.domain.domainModule
import es.jfechevarria.github_sdk.githubModule
import es.jfechevarria.room.roomModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    githubModule,
                    roomModule,
                    domainModule,
                    usecaseModule,
                    viewModelModule
                ))
        }
    }
}