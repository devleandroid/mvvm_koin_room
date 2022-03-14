package br.com.framework.mvvm.koin

import android.app.Application
import br.com.framework.mvvm.koin.di.mainViewModel
import br.com.framework.mvvm.koin.di.userDB
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                userDB,
                mainViewModel
            )
        }
    }
}