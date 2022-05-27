package com.example.dramkos.util

import android.app.Application
import com.chibatching.kotpref.Kotpref
import com.example.dramkos.core.di.appModule
import com.example.dramkos.core.di.repositoryModule
import com.example.dramkos.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Kotpref.init(this)
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule, viewModelModule, repositoryModule))
        }
    }
}