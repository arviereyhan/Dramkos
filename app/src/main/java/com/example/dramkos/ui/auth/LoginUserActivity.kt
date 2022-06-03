package com.example.dramkos.ui.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dramkos.core.data.source.remote.network.State
import com.example.dramkos.core.data.source.remote.request.LoginRequest
import com.example.dramkos.databinding.ActivityLoginUserBinding
import com.example.dramkos.ui.navigation.NavigationUserActivity
import com.example.dramkos.util.Constants
import com.example.dramkos.util.Prefs
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginUserActivity : AppCompatActivity() {

    private val viewModel: AuthViewModel by viewModel()

    private var _binding: ActivityLoginUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        mainButton()
    }

    private fun mainButton() {
        binding.btnMasuk.setOnClickListener {
            login()
        }

        binding.btnAdmin.setOnClickListener {
            intentActivity(LoginAdminActivity::class.java)
        }

        binding.btnDaftar.setOnClickListener {
            intentActivity(RegisterUserActivity::class.java)
        }
    }

    private fun setData() {

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

    private fun login() {

        if (binding.edtEmail.isEmpty()) return
        if (binding.edtPassword.isEmpty()) return

        val body = LoginRequest(
            binding.edtEmail.text.toString(),
            binding.edtPassword.text.toString()
        )

        viewModel.userLogin(body).observe(this, {
            when (it.state) {
                State.SUCCESS -> {
                    dismisLoading()
                    showToast("Selamat datang " + it.data?.nama)
                    pushActivity(NavigationUserActivity::class.java)
                }
                State.ERROR -> {
                    dismisLoading()
                    toastError(it.message ?: "Error")
                }
                State.LOADING -> {
                    showLoading()
                }
            }
        })
    }

}