package com.example.kraskrit.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel: ViewModel() {
    val dataToShare = MutableLiveData<String>()

    fun updateData(data: String) {
        dataToShare.value = data
    }
}