package com.example.dramkos.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.dramkos.core.data.repository.AppRepository
import com.example.dramkos.core.data.source.remote.request.LoginRequest
import com.example.dramkos.core.data.source.remote.request.RegisterRequest
import okhttp3.MultipartBody

class AuthViewModel(val repo: AppRepository) : ViewModel() {

    fun login(data: LoginRequest) = repo.login(data).asLiveData()

    fun register(data: RegisterRequest) = repo.register(data).asLiveData()
}