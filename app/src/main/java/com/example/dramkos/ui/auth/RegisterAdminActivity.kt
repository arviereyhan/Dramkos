package com.example.dramkos.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isEmpty
import com.example.dramkos.core.data.source.remote.network.State
import com.example.dramkos.core.data.source.remote.request.RegisterRequest
import com.example.dramkos.databinding.ActivityRegisterAdminBinding
import com.example.dramkos.databinding.ActivityRegisterUserBinding
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterAdminActivity : AppCompatActivity() {

    private val viewModel: AuthViewModel by viewModel()

    private var _binding: ActivityRegisterAdminBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRegisterAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)



        setData()
    }

    private fun setData() {
        binding.btnUser.setOnClickListener {
            intentActivity(RegisterUserActivity::class.java)
        }
        binding.btnMasuk.setOnClickListener {
            intentActivity(LoginAdminActivity::class.java)
        }
        binding.btnDaftar.setOnClickListener {
            register()
        }

    }

    private fun register() {

        if (binding.edtName.isEmpty()) return
        if (binding.edtEmail.isEmpty()) return
        if (binding.edtPhone.isEmpty()) return
        if (binding.edtPassword.isEmpty()) return

        val body = RegisterRequest(
            binding.edtName.text.toString(),
            binding.edtEmail.text.toString(),
            binding.edtPhone.text.toString(),
            binding.edtPassword.text.toString()
        )

        viewModel.adminRegister(body).observe(this, {

            when (it.state) {
                State.SUCCESS -> {
//                    dismisLoading()
                    showToast("Register Sukses\nSilahkan Login")
                    pushActivity(LoginAdminActivity::class.java)
                }
                State.ERROR -> {
//                    dismisLoading()
                    toastError(it.message ?: "Error")
                }
                State.LOADING -> {
//                    showLoading()
                }
            }
        })
    }

}