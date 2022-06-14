package com.example.dramkos.ui.admin.detailkosadmin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dramkos.core.data.source.model.Kos
import com.example.dramkos.core.data.source.remote.network.State
import com.example.dramkos.databinding.FragmentTambahkosBinding
import com.example.dramkos.databinding.TampilanKosAdminBinding
import com.example.dramkos.databinding.TampilanKosBinding
import com.example.dramkos.ui.admin.editkos.EditKosActivity
import com.example.dramkos.ui.auth.AuthViewModel
import com.example.dramkos.ui.base.MyActivity
import com.example.dramkos.ui.navigation.NavigationAdminActivity
import com.example.dramkos.util.Constants
import com.example.dramkos.util.getAdminId
import com.example.dramkos.util.getKosId
import com.inyongtisto.myhelper.extension.*
import okhttp3.internal.cache2.Relay.Companion.edit
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.nio.file.Files.delete

class DetailKosAdminActivity : AppCompatActivity() {
    private val viewModel: AuthViewModel by viewModel()

    private var _binding: TampilanKosAdminBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = TampilanKosAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getExtra()
        getData()
        Log.d("TAG", "ini detail kos admin")
        binding.btnDelete.setOnClickListener{
            delete()
        }
        binding.btnEdit.setOnClickListener{
            edit(kos)
        }
    }

    private var kos = Kos()

    private fun Kos(): Kos {
        return kos
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

    private fun getExtra(){
        val extra: String? = getStringExtra()
        kos = extra.toModel(Kos::class.java) ?: Kos()

        binding.apply {
            namaKos.text = kos.namaKos
            daerahKos.text = kos.alamat
            kisaranHarga.text = kos.harga.toString()
        }
    }

    private fun delete(){
        val extra: String? = getStringExtra()
        kos = extra.toModel(Kos::class.java) ?: Kos()
        val reqData1 = Kos(
            id = kos.id,
        )
        viewModel.delete(reqData1).observe(this) {
            when (it.state) {
                State.SUCCESS -> {
                    dismisLoading()
                    showToast("Hapus Kos Sukses")
                    finish()
                }
                State.ERROR -> {
                    dismisLoading()
                    Log.d("TAG", it.message ?: "Error")
                    toastError(it.message ?: "Error")
                }
                State.LOADING -> {

                }
            }
        }
    }

    private fun edit(item: Kos){
        intentActivity(
            EditKosActivity::class.java,
            item.toJson()
        )
    }
}