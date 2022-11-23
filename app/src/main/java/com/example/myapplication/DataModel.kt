package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel: ViewModel() {
    val loginName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}