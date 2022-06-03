package com.example.dramkos.ui.navigation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.dramkos.R
import com.example.dramkos.core.data.source.model.Kos
import com.example.dramkos.core.data.source.remote.network.State

import com.example.dramkos.databinding.ActivityNavigationUserBinding
import com.example.dramkos.databinding.FragmentHomeUserBinding
import com.example.dramkos.ui.auth.LoginAdminActivity
import com.example.dramkos.ui.auth.LoginUserActivity
import com.example.dramkos.ui.user.home.HomeFragment
import com.example.dramkos.ui.user.home.HomeViewModel
import com.example.dramkos.util.Prefs
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.inyongtisto.myhelper.extension.intentActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.dramkos.ui.user.home.adapter.ProductKosAdapter
import com.example.dramkos.util.Constants
import com.inyongtisto.myhelper.extension.dismisLoading
import com.inyongtisto.myhelper.extension.toastError

class NavigationUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationUserBinding
    private val viewModel: NavViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationUserBinding.inflate(layoutInflater)
        getData()
        setContentView(binding.root)
        setupNav()
    }

    private fun setupNav() {
        val navView: BottomNavigationView = binding.navView
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_navigation_user) as NavHostFragment
        val navController = navHostFragment.navController

        navView.setupWithNavController(navController)
        navView.setOnItemSelectedListener {
            getData()
            navController.navigate(it.itemId)
            Log.d("TAG", "onCreate: yg lain" + it.itemId)

            return@setOnItemSelectedListener true
        }
    }
    fun getData() {
        viewModel.get().observe(this) {
            when (it.state) {
                State.SUCCESS -> {
                    Constants.dataaa = it.data ?: emptyList()
                    Log.d("TAG", "onCreate: yg lain"+ Constants.dataaa)
                }
                State.ERROR -> {
//                    dismisLoading()
                    toastError(it.message ?: "Error")
                }
                State.LOADING -> {
//                    showLoading()
                }
            }
        }
    }


    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}