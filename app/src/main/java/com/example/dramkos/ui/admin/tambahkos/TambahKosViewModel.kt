package com.example.dramkos.ui.admin.tambahkos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TambahKosViewModel  : ViewModel(){
    private val _text = MutableLiveData<String>().apply {
        value = "This is tambahkos Fragment"
    }
    val text: LiveData<String> = _text
}