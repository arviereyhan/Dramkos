package com.example.dramkos.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dramkos.core.data.source.remote.network.State
import com.example.dramkos.core.data.source.remote.request.LoginRequest
import com.example.dramkos.databinding.ActivityLoginUserBinding

import com.example.dramkos.ui.navigation.NavigationUserActivity
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

        setData()
        mainButton()
    }

    private fun mainButton() {
        binding.btnMasuk.setOnClickListener {
            login()
        }

        binding.btnUser.setOnClickListener {
            intentActivity(LoginAdminActivity::class.java)
        }

        binding.btnDaftar.setOnClickListener {
            intentActivity(RegisterUserActivity::class.java)
        }
    }

    private fun setData() {

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