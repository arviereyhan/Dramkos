package com.example.dramkos.ui.admin.detailkosadmin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.dramkos.core.data.repository.AppRepository
import com.example.dramkos.core.data.source.local.DummyData
import com.example.dramkos.core.data.source.model.Kos

class DetailKosAdminViewModel(val repo: AppRepository) : ViewModel() {
    fun get() = repo.getKos().asLiveData()
    fun delete(data: Kos) = repo.deleteKos(data).asLiveData()
}