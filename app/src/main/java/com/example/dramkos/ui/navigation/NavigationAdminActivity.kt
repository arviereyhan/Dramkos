package com.example.dramkos.ui.navigation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.dramkos.R
import com.example.dramkos.databinding.ActivityNavigationAdminBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class NavigationAdminActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationAdminBinding
    private val viewModel: NavViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNav()

    }

    private fun setupNav() {
        val navView: BottomNavigationView = binding.navView
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_navigation_admin) as NavHostFragment
        val navController = navHostFragment.navController

        navView.setupWithNavController(navController)
        navView.setOnItemSelectedListener {

                navController.navigate(it.itemId)
                Log.d("TAG", "onCreate: yg lain" + it.itemId)

            return@setOnItemSelectedListener true
        }
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}