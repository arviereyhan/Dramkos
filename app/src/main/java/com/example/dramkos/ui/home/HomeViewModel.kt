package com.example.dramkos.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dramkos.core.data.source.local.DummyData
import com.example.dramkos.core.data.source.model.Kos

class HomeViewModel : ViewModel() {

    val listKos: LiveData<List<Kos>> = MutableLiveData<List<Kos>>().apply {
        value = DummyData.listKos
    }
}