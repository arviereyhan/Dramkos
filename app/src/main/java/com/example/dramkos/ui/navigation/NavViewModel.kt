package com.example.dramkos.ui.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.dramkos.core.data.repository.AppRepository

class NavViewModel(val repo: AppRepository) : ViewModel() {
    fun get() = repo.getKos().asLiveData()
}