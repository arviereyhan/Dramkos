package com.example.dramkos.core.data.source.local

import com.example.dramkos.R
import com.example.dramkos.core.data.source.model.Bookmark
import com.example.dramkos.core.data.source.model.Kos

object DummyData {
    val listKos = listOf(
        Kos(id = 1, name = "D'Campus", image = R.drawable.asset_kos, daerah = "Babakan Lebak", jarak = 0.5, rating = 4.6, alamat = "Jl. Yang Lurus Nomor 12, samping pos satpam", harga = 500000),
        Kos(id = 2, name = "Dramaga Cantik", image = R.drawable.asset_kos, daerah = "Dramaga", jarak = 0.3, rating = 4.2, alamat = "Jl. Yang Lurus Nomor 12, samping pos satpam", harga = 500000),
        Kos(id = 3, name = "Ujung", image = R.drawable.asset_kos, daerah = "Babakan Raya", jarak = 0.6, rating = 4.8, alamat = "Jl. Yang Lurus Nomor 12, samping pos satpam", harga = 500000),
        Kos(id = 4, name = "Tak tau", image = R.drawable.asset_kos, daerah = "Babakan Tengah", jarak = 0.8, rating = 4.4, alamat = "Jl. Yang Lurus Nomor 12, samping pos satpam", harga = 500000),
        Kos(id = 5, name = "Suka suka sya", image = R.drawable.asset_kos, daerah = "Dimana kek", jarak = 1.8, rating = 3.4, alamat = "Jl. Yang Lurus Nomor 12, samping pos satpam", harga = 500000),
        Kos(id = 6, name = "Apa Ya?", image = R.drawable.asset_kos, daerah = "Jauhh", jarak = 2.8, rating = 5.0, alamat = "Jl. Yang Lurus Nomor 12, samping pos satpam", harga = 500000)
    )
}