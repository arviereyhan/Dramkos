package com.example.dramkos.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.dramkos.core.data.repository.AppRepository
import com.example.dramkos.core.data.source.model.Kos
import com.example.dramkos.core.data.source.remote.request.LoginRequest
import com.example.dramkos.core.data.source.remote.request.RegisterRequest

class AuthViewModel(val repo: AppRepository) : ViewModel() {

    fun userLogin(data: LoginRequest) = repo.userLogin(data).asLiveData()
    fun adminLogin(data: LoginRequest) = repo.adminLogin(data).asLiveData()

    fun userRegister(data: RegisterRequest) = repo.userRegister(data).asLiveData()
    fun adminRegister(data: RegisterRequest) = repo.adminRegister(data).asLiveData()

    fun get() = repo.getKos().asLiveData()
    fun create(data: Kos) = repo.createKos(data).asLiveData()
    fun update(data: Kos) = repo.updateKos(data).asLiveData()
    fun delete(data: Kos) = repo.deleteKos(data).asLiveData()
}