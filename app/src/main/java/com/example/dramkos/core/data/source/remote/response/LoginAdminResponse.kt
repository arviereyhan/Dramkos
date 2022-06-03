package com.example.dramkos.core.data.source.remote.response

import com.example.dramkos.core.data.source.model.Admin

data class LoginAdminResponse(
    val code: Int? = null,
    val message: String? = null,
    val data: Admin? = null
)