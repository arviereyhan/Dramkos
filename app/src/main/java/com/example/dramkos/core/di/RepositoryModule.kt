package com.example.dramkos.core.di

import com.example.dramkos.core.data.repository.AppRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { AppRepository(get(), get()) }
}