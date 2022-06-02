package com.example.dramkos.core.data.source.local

import com.example.dramkos.R
import com.example.dramkos.core.data.source.model.Bookmark
import com.example.dramkos.core.data.source.model.Kos

object DummyData {
    val listKos = listOf(
        Kos(id = 1, name = "D'Campus", image = R.drawable.asset_kos, alamat = "Babakan Lebak", jarak = 0.5, rating = 4.6),
        Kos(id = 2, name = "Dramaga Cantik", image = R.drawable.asset_kos, alamat = "Dramaga", jarak = 0.3, rating = 4.2),
        Kos(id = 3, name = "Ujung", image = R.drawable.asset_kos, alamat = "Babakan Raya", jarak = 0.6, rating = 4.8),
        Kos(id = 4, name = "Tak tau", image = R.drawable.asset_kos, alamat = "Babakan Tengah", jarak = 0.8, rating = 4.4),
        Kos(id = 5, name = "Suka suka sya", image = R.drawable.asset_kos, alamat = "Dimana kek", jarak = 1.8, rating = 3.4),
        Kos(id = 6, name = "Apa Ya?", image = R.drawable.asset_kos, alamat = "Jauhh", jarak = 2.8, rating = 5.0)
    )
}