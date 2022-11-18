package com.example.kotlincoroutines.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincoroutines.model.ApiUser
import com.example.kotlincoroutines.network.ApiHelper
import com.example.kotlincoroutines.utilities.Resource
import kotlinx.coroutines.launch

class SingleNetworkCallViewModel(private val apiHelper: ApiHelper): ViewModel() {
val user=MutableLiveData<Resource<List<ApiUser>>>()
    init {
        fetchUser()
    }
    private fun fetchUser(){
        viewModelScope.launch {
            user.postValue(Resource.Loading())
            try {
               user.postValue(Resource.Success(apiHelper.getUser()))
            }catch (e:Exception){
                user.postValue(Resource.Error(e))
            }
        }
    }
}