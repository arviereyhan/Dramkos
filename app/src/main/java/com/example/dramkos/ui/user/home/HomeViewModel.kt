package com.example.dramkos.ui.user.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.dramkos.core.data.repository.AppRepository
import com.example.dramkos.core.data.source.local.DummyData
import com.example.dramkos.core.data.source.local.LocalDataSource
import com.example.dramkos.core.data.source.model.Kos
import com.example.dramkos.core.data.source.remote.RemoteDataSource
import okhttp3.Response

class HomeViewModel() : ViewModel() {
    val listKos: LiveData<List<Kos>> = MutableLiveData<List<Kos>>().apply {
        value = DummyData.listKos
    }
}