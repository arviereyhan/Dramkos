package com.example.dramkos.core.data.source.remote.request

data class RegisterRequest(
    val nama: String,
    val email: String,
    val phone: String?,
    val password: String
)
