package com.example.dramkos.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dramkos.core.data.source.remote.network.State
import com.example.dramkos.core.data.source.remote.request.RegisterRequest
import com.example.dramkos.databinding.ActivityRegisterUserBinding
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterUserActivity : AppCompatActivity() {

    private val viewModel: AuthViewModel by viewModel()

    private var _binding: ActivityRegisterUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRegisterUserBinding.inflate(layoutInflater)
        setContentView(binding.root)



        setData()
    }

    private fun setData() {
        binding.btnAdmin.setOnClickListener {
            intentActivity(RegisterAdminActivity::class.java)
        }
        binding.btnDaftar.setOnClickListener {
            register()
        }

    }

    private fun register() {

        if (binding.edtName.isEmpty()) return
        if (binding.edtEmail.isEmpty()) return
        if (binding.edtPassword.isEmpty()) return

        val body = RegisterRequest(
            binding.edtName.text.toString(),
            binding.edtEmail.text.toString(),
            null,
            binding.edtPassword.text.toString()
        )

        viewModel.userRegister(body).observe(this, {

            when (it.state) {
                State.SUCCESS -> {
//                    dismisLoading()
                    showToast("Selamat datang " + it.data?.nama)
                    pushActivity(LoginUserActivity::class.java)
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