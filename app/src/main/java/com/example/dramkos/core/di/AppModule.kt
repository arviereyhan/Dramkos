package com.example.dramkos.core.di

import com.example.dramkos.core.data.source.local.LocalDataSource
import com.example.dramkos.core.data.source.remote.RemoteDataSource
import com.example.dramkos.core.data.source.remote.network.ApiConfig
import org.koin.dsl.module

val appModule = module {
    single { ApiConfig.provideApiService }

    single { RemoteDataSource(get()) }

    single { LocalDataSource() }
}