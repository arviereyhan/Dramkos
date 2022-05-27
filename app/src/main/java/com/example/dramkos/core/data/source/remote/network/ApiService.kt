package com.example.dramkos.core.data.source.remote.network

import com.example.dramkos.core.data.source.remote.request.LoginRequest
import com.example.dramkos.core.data.source.remote.request.RegisterRequest
import com.example.dramkos.core.data.source.remote.response.BaseListResponse
import com.example.dramkos.core.data.source.remote.response.BaseSingelResponse
import com.example.dramkos.core.data.source.remote.response.LoginResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("userLogin")
    suspend fun login(
        @Body login: LoginRequest,
    ): Response<LoginResponse>

    // "https://127.0.0.1:8000/api/register"
    @POST("register")
    suspend fun register(
        @Body data: RegisterRequest
    ): Response<LoginResponse>
}