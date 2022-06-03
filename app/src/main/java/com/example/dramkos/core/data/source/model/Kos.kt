package com.example.dramkos.core.data.source.model

data class Kos(
    val id: Int,
    val name: String,
    val image: Int,
    val alamat: String,
    val daerah: String,
    val harga: Int,
    val jarak: Double,
    val rating: Double,
)