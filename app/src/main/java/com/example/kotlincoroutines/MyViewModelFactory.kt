package com.example.kotlincoroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincoroutines.network.ApiHelper
import com.example.kotlincoroutines.viewmodel.SeriesViewModel
import com.example.kotlincoroutines.viewmodel.SingleNetworkCallViewModel

class MyViewModelFactory(private val apiHelper: ApiHelper):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SingleNetworkCallViewModel::class.java))
        return SingleNetworkCallViewModel(apiHelper) as T
        if(modelClass.isAssignableFrom(SeriesViewModel::class.java))
            return SeriesViewModel(apiHelper) as T
        return SingleNetworkCallViewModel(apiHelper) as T
    }
}