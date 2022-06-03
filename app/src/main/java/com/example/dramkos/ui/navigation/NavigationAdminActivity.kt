package com.example.dramkos.ui.navigation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.dramkos.R
import com.example.dramkos.core.data.source.remote.network.State
import com.example.dramkos.databinding.ActivityNavigationAdminBinding
import com.example.dramkos.ui.admin.tambahkos.TambahKosActivity
import com.example.dramkos.util.Constants
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class NavigationAdminActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationAdminBinding
    private val viewModel: NavViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        setupNav()

    }

    private fun setupNav() {
        val navView: BottomNavigationView = binding.navView
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_navigation_admin) as NavHostFragment
        val navController = navHostFragment.navController

        navView.setupWithNavController(navController)
        navView.setOnItemSelectedListener {
            getData()
            if (it.itemId == R.id.navigation_tambahkos) {
                startActivity(Intent(this, TambahKosActivity::class.java))
                Log.d("TAG", "belum login, pindah ke maenu login")
                return@setOnItemSelectedListener false

            } else {
                navController.navigate(it.itemId)
                Log.d("TAG", "onCreate: yg lain" + it.itemId)
            }
            return@setOnItemSelectedListener true
        }
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

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}