package com.example.kotlincoroutines.network

import com.example.kotlincoroutines.model.ApiUser

interface ApiHelper {
    suspend fun getUser():List<ApiUser>
    suspend fun getMoreUser():List<ApiUser>
}