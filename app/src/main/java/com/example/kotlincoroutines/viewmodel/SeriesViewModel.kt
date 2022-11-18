package com.example.kotlincoroutines.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincoroutines.model.ApiUser
import com.example.kotlincoroutines.network.ApiHelper
import com.example.kotlincoroutines.utilities.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val TAG = "SeriesViewModel"
class SeriesViewModel(private val apiHelper: ApiHelper):ViewModel() {
    var user=MutableLiveData<Resource<List<ApiUser>>>()

    init {
        fetchUser()
    }
    private fun fetchUser(){

        viewModelScope.launch {
            user.postValue(Resource.Loading())
            try {
                firstFunction()
                var userList=apiHelper.getUser()
                var moreUserList=apiHelper.getMoreUser()
                var completeList= mutableListOf<ApiUser>()
                completeList.addAll(userList)
                completeList.addAll(moreUserList)
                user.postValue(Resource.Success(completeList))


            }catch (e:Exception){
                user.postValue(Resource.Error(e))
            }
        }
        viewModelScope.launch {
            secondFunction()
        }
    }

    suspend fun firstFunction(){
        Log.e(TAG,"startFirstFunction")
        delay(3000)
        Log.e(TAG,"endFirst Function")
    }
    suspend fun secondFunction(){
        Log.e(TAG,"secondFunction")
        delay(3000)
        Log.e(TAG,"endSecondFunction")
    }
}