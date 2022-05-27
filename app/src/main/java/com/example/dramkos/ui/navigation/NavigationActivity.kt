package com.example.dramkos.ui.navigation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.dramkos.R
import com.example.dramkos.databinding.ActivityNavigationBinding
import com.example.dramkos.ui.auth.LoginActivity
import com.example.dramkos.util.Prefs
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class NavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationBinding
    private val viewModel: NavViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNav()
    }

    private fun setupNav() {
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_navigation)

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