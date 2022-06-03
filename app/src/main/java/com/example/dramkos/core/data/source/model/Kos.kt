package com.example.dramkos.core.data.source.model

data class Kos(
    val id: Int?,
    val adminID: Int? = null,
    val namaKos: String? = null,
    val alamat: String? = null,
    val fasilitas: Int? = null,
    val harga: Int? = null,
    val rating: Double? = null,
)