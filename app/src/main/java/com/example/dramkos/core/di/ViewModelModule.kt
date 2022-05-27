package com.example.dramkos.core.di

import com.example.dramkos.ui.auth.AuthViewModel
import com.example.dramkos.ui.navigation.NavViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AuthViewModel(get()) }
    viewModel { NavViewModel(get()) }
}