package com.example.dramkos.util

fun String?.defaultError(): String {
    return this ?: Constants.DEFALUT_ERROR
}