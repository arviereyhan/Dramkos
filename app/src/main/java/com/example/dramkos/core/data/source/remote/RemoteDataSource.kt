package com.example.dramkos.core.data.source.remote

import com.example.dramkos.core.data.source.remote.network.ApiService
import com.example.dramkos.core.data.source.remote.request.LoginRequest
import com.example.dramkos.core.data.source.remote.request.RegisterRequest
import okhttp3.MultipartBody

class RemoteDataSource(private val api: ApiService) {

    suspend fun login(data: LoginRequest) = api.login(data)

    suspend fun register(data: RegisterRequest) = api.register(data)
}