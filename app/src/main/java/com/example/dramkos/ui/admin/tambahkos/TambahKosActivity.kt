package com.example.dramkos.ui.admin.tambahkos

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import com.example.dramkos.R
import com.example.dramkos.core.data.source.model.Fasilitas
import com.example.dramkos.core.data.source.model.Kos
import com.example.dramkos.databinding.FragmentTambahkosBinding
import com.example.dramkos.ui.base.MyActivity
import com.example.dramkos.util.Prefs.getKosId
import com.inyongtisto.myhelper.extension.getString
import com.inyongtisto.myhelper.extension.isEmpty
import org.koin.androidx.viewmodel.ext.android.viewModel


class TambahKosActivity : MyActivity() {
    private lateinit var binding: FragmentTambahkosBinding
    private val viewModel: TambahKosViewModel by viewModel()
    private var fasilAC: Int? = null
    private var fasilWifi: Int? = null
    private var fasilKamarMandi: Int? = null
    private var fasilKitchen: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentTambahkosBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.fasil_ac -> {
                    if (checked) {
                        fasilAC = 1
                    } else {
                        fasilAC = 0
                    }
                }
                R.id.fasil_kamarmandi -> {
                    if (checked) {
                        fasilKamarMandi = 1
                    } else {
                        fasilKamarMandi = 0
                    }
                }
                R.id.fasil_kitchen -> {
                    if (checked) {
                        fasilKitchen = 1
                    } else {
                        fasilKitchen = 0
                    }
                }
                R.id.fasil_wifi -> {
                    if (checked) {
                        fasilWifi = 1
                    } else {
                        fasilWifi = 0
                    }
                }
            }
        }
    }

    private fun mainButton() {
        binding.apply {
            tambahKos.setOnClickListener {
                if (validate()) simpan()
            }
        }
        
    }

    private fun validate(): Boolean {
        binding.apply {
            if (colomTextKos.isEmpty()) return false
            if (colomAlamat.isEmpty()) return false
            if (colomDaerah.isEmpty()) return false
            if (colomJarak.isEmpty()) return false
            if (kisaranHarga.isEmpty()) return false
        }
        return true
    }

    private fun simpan() {
        val reqData1 = Kos(
            id = getKosId(),
            name = binding.colomTextKos.getString(),
            alamat = binding.colomAlamat.getString(),
            daerah = binding.colomDaerah.getString(),
            harga = binding.kisaranHarga.getString(),
            jarak = binding.colomJarak.getString(),
        )
        val reqData2 = Fasilitas(
            id = getKosId(),
            fasilAC =  fasilAC,
            fasilWifi = fasilWifi,
            fasilKamarMandi = fasilKamarMandi,
            fasilKitchen = fasilKitchen,
        )


    }
}