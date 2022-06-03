package com.example.dramkos.core.data.source.local

import com.example.dramkos.R
import com.example.dramkos.core.data.source.model.Bookmark
import com.example.dramkos.core.data.source.model.Kos

object DummyData {
    val listKos = listOf(
        Kos(id = 1, adminID = 1, namaKos = "D'Campus",  harga = 300000,  rating = 4.6),
        Kos(id = 2, adminID = 1, namaKos = "Dramaga Cantik",  harga = 500000, rating = 4.2),
        /*Kos(id = 3, adminId = 1, namaKos = "Ujung", alamat = "Babakan Raya", jarak = 0.6, rating = 4.8),
        Kos(id = 4, adminId = 1, namaKos = "Tak tau", alamat = "Babakan Tengah", jarak = 0.8, rating = 4.4),
        Kos(id = 5, adminId = 1, namaKos = "Suka suka sya", alamat = "Dimana kek", jarak = 1.8, rating = 3.4),
        Kos(id = 6, adminId = 1, namaKos = "Apa Ya?", alamat = "Jauhh", jarak = 2.8, rating = 5.0)*/
    )
}