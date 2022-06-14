package com.example.dramkos.core.data.source.remote.network

import com.example.dramkos.core.data.source.model.Kos
import com.example.dramkos.core.data.source.remote.request.LoginRequest
import com.example.dramkos.core.data.source.remote.request.RegisterRequest
import com.example.dramkos.core.data.source.remote.response.*
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("userLogin")
    suspend fun userLogin(
        @Body login: LoginRequest,
    ): Response<LoginUserResponse>

    @POST("adminLogin")
    suspend fun adminLogin(
        @Body login: LoginRequest,
    ): Response<LoginAdminResponse>

    @POST("userRegister")
    suspend fun userRegister(
        @Body data: RegisterRequest
    ): Response<LoginUserResponse>

    @POST("adminRegister")
    suspend fun adminRegister(
        @Body data: RegisterRequest
    ): Response<LoginAdminResponse>

    @GET("kos")
    suspend fun getKos()
    : Response<BaseListResponse<Kos>>

    @POST("kos")
    suspend fun createKos(
        @Body data: Kos
    ): Response<BaseSingelResponse<Kos>>

    @PUT("kos/{id}")
    suspend fun updateKos(
        @Path("id") id: Int? = null,
        @Body data: Kos
    ): Response<BaseSingelResponse<Kos>>

    @DELETE("kos/{id}")
    suspend fun deleteKos(
        @Path("id") id: Int? = null,
    ): Response<BaseSingelResponse<Kos>>


}