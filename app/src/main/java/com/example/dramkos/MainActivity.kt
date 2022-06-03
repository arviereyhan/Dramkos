package com.example.dramkos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.dramkos.core.data.source.remote.network.State
import com.example.dramkos.ui.auth.LoginUserActivity
import com.example.dramkos.ui.navigation.NavViewModel
import com.example.dramkos.ui.navigation.NavigationAdminActivity
import com.example.dramkos.ui.navigation.NavigationUserActivity
import com.example.dramkos.ui.user.home.HomeViewModel
import com.example.dramkos.util.Constants
import com.example.dramkos.util.Prefs
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    private val viewModel: NavViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }




}