package com.example.dramkos.ui.admin.tambahkos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dramkos.core.data.source.model.Kos
import com.example.dramkos.core.data.source.remote.network.State
import com.example.dramkos.databinding.FragmentTambahkosBinding
import com.example.dramkos.ui.auth.AuthViewModel
import com.example.dramkos.ui.navigation.NavigationAdminActivity
import com.example.dramkos.util.Constants
import com.example.dramkos.util.getAdminId
import com.example.dramkos.util.getKosId
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TambahKosActivity : AppCompatActivity() {

    private val viewModel: AuthViewModel by viewModel()

    private var _binding: FragmentTambahkosBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = FragmentTambahkosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setData()
    }

    private fun setData() {
        binding.tambahKos.setOnClickListener {
            if (validate()) simpan()
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

    fun getData() {
        viewModel.get().observe(this) {
            when (it.state) {
                State.SUCCESS -> {
                    Constants.dataaa = it.data ?: emptyList()
                }
            }
        }
    }

    private fun simpan() {

        val reqData1 = Kos(
            id = getKosId(),
            adminID = getAdminId(),
            namaKos = binding.colomTextKos.getString(),
            alamat = binding.colomDaerah.getString(),
            fasilitas = 1,
            harga = binding.kisaranHarga.getString().toInt(),
        )

        val data = Kos(
            id = 1,
            adminID = 1,
            namaKos = "cek",
            alamat = "babakan",
            fasilitas = 1,
            harga = 1000
        )

        val body = Kos(
            1,
            1,
            "cekk",
            "123",
            1,
            100,
            1.0,
        )

        viewModel.create(reqData1).observe(this) {
            when (it.state) {
                State.SUCCESS -> {
                    dismisLoading()
                    showToast("Tambah Kos Sukses")
                    getData()
                    pushActivity(NavigationAdminActivity::class.java)
                }
                State.ERROR -> {
                    dismisLoading()
                    toastError(it.message ?: "Error")
                }
                State.LOADING -> {

                }
            }
        }


    }}



/*
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

        mainButton()

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
        binding.tambahKos.setOnClickListener {
            simpan()
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

        val data = Kos(
            adminID = 1,
            namaKos = "cek",
            alamat = "babakan",
            harga = 1000
        )

        val body = Kos(
            1,
            "cekk",
            "123",
            "123",
            123,
            1.1,
            1.0,
        )

        viewModel.create(body).observe(this) {
            when (it.state) {
                State.SUCCESS -> {
                    dismisLoading()
                    showToast("Tambah Kos Sukses")
                    pushActivity(NavigationAdminActivity::class.java)
                }
                State.ERROR -> {
                    dismisLoading()
                    toastError(it.message ?: "Error")
                }
                State.LOADING -> {
                    showLoading()
                }
            }
        }


    }
}*/
