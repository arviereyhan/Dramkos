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
    suspend fun userLogin(
        @Body login: LoginRequest,
    ): Response<LoginResponse>

    @POST("adminLogin")
    suspend fun adminLogin(
        @Body login: LoginRequest,
    ): Response<LoginResponse>

    @POST("userRegister")
    suspend fun userRegister(
        @Body data: RegisterRequest
    ): Response<LoginResponse>

    @POST("adminRegister")
    suspend fun adminRegister(
        @Body data: RegisterRequest
    ): Response<LoginResponse>
}