package com.example.dramkos.ui.user.detailkos

import android.os.Bundle
import com.example.dramkos.core.data.source.model.Kos
import com.example.dramkos.databinding.TampilanKosBinding
import com.example.dramkos.ui.base.MyActivity
import com.inyongtisto.myhelper.extension.getStringExtra
import com.inyongtisto.myhelper.extension.toModel

class DetailKosActivity : MyActivity() {
    private lateinit var binding : TampilanKosBinding
    private lateinit var viewModel: DetailKosViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TampilanKosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getExtra()

    }

    private var kos = Kos()

    private fun Kos(): Kos {
        return kos
    }

    private fun getExtra(){
        val extra: String? = getStringExtra()
        kos = extra.toModel(Kos::class.java) ?: Kos()

        binding.apply {
            fotoKos.setImageResource(kos.image!!)
            namaJarak.text = kos.name + "-" + kos.jarak + "km"
            daerahKos.text = kos.daerah
            kisaranHarga.text = kos.harga.toString()
            alamatKos.text = kos.alamat

        }
    }

}