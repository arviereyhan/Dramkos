package com.example.dramkos.core.data.repository

import com.example.dramkos.core.data.source.local.LocalDataSource
import com.example.dramkos.core.data.source.model.Kos
import com.example.dramkos.core.data.source.remote.RemoteDataSource
import com.example.dramkos.core.data.source.remote.network.Resource
import com.example.dramkos.core.data.source.remote.request.LoginRequest
import com.example.dramkos.core.data.source.remote.request.RegisterRequest
import com.example.dramkos.core.data.source.remote.request.UpdateProfileRequest
import com.example.dramkos.util.Prefs
import com.inyongtisto.myhelper.extension.getErrorBody
import com.inyongtisto.myhelper.extension.logs
import kotlinx.coroutines.flow.flow
import okhttp3.MultipartBody
import java.lang.Exception

class AppRepository(val local: LocalDataSource, val remote: RemoteDataSource) {

    fun userLogin(data: LoginRequest) = flow {
        emit(Resource.loading(null))
        try {
            remote.userLogin(data).let {
                if (it.isSuccessful) {
                    Prefs.isLogin = true
                    val body = it.body()
                    val user = body?.data
                    Prefs.setUser(user)
                    emit(Resource.success(user))
                    logs("succes:" + body.toString())
                } else {
                    emit(Resource.error(it.getErrorBody()?.message ?: "Default error dongs", null))
                    logs("Error:" + "keteragan error")
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message ?: "Terjadi Kesalahan", null))
            logs("Error:" + e.message)
        }
    }

    fun adminLogin(data: LoginRequest) = flow {
        emit(Resource.loading(null))
        try {
            remote.adminLogin(data).let {
                if (it.isSuccessful) {
                    Prefs.isLogin = true
                    val body = it.body()
                    val user = body?.data
                    Prefs.setAdmin(user)
                    emit(Resource.success(user))
                    logs("succes:" + body.toString())
                } else {
                    emit(Resource.error(it.getErrorBody()?.message ?: "Default error dongs", null))
                    logs("Error:" + "keteragan error")
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message ?: "Terjadi Kesalahan", null))
            logs("Error:" + e.message)
        }
    }

    fun userRegister(data: RegisterRequest) = flow {
        emit(Resource.loading(null))
        try {
            remote.userRegister(data).let {
                if (it.isSuccessful) {
                    Prefs.isLogin = true
                    val body = it.body()
                    val user = body?.data
                    Prefs.setUser(user)
                    emit(Resource.success(user))
                    logs("succes:" + body.toString())
                } else {
                    emit(Resource.error(it.getErrorBody()?.message ?: "Default error dongs", null))
                    logs("Error:" + "keteragan error")
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message ?: "Terjadi Kesalahan", null))
            logs("Error:" + e.message)
        }
    }

    fun adminRegister(data: RegisterRequest) = flow {
        emit(Resource.loading(null))
        try {
            remote.adminRegister(data).let {
                if (it.isSuccessful) {
                    Prefs.isLogin = true
                    val body = it.body()
                    val user = body?.data
                    Prefs.setAdmin(user)
                    emit(Resource.success(user))
                    logs("succes:" + body.toString())
                } else {
                    emit(Resource.error(it.getErrorBody()?.message ?: "Default error dongs", null))
                    logs("Error:" + "keteragan error")
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message ?: "Terjadi Kesalahan", null))
            logs("Error:" + e.message)
        }
    }

    fun getKos() = flow {
        emit(Resource.loading(null))
        try {
            remote.getKos().let {
                if (it.isSuccessful) {
                    val body = it.body()
                    val data = body?.data

                    emit(Resource.success(data))
                } else {
                    emit(Resource.error(it.getErrorBody()?.message ?: "Default error dongs", null))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message ?: "Terjadi Kesalahan", null))
        }
    }

    fun createKos(data: Kos) = flow {
        emit(Resource.loading(null))
        try {
            remote.createKos(data).let {
                if (it.isSuccessful) {
                    val body = it.body()?.data
                    emit(Resource.success(body))
                } else {
                    emit(Resource.error(it.getErrorBody()?.message ?: "Default error dongs", null))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message ?: "Terjadi Kesalahan", null))
        }
    }



}