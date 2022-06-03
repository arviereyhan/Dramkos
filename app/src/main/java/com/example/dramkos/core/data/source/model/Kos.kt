package com.example.dramkos.core.data.source.model

import android.widget.EditText

data class Kos(
    val id: Int?,
    val name: String,
    val image: Int? = null,
    val alamat: String,
    val daerah: String,
    val harga: String,
    val jarak: String,
    val rating: Double? = null,
)