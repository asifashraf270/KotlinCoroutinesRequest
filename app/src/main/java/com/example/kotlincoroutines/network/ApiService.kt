package com.example.kotlincoroutines.network

import com.example.kotlincoroutines.model.ApiUser
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<ApiUser>

    @GET("more-users")
    suspend fun getMoreUsers():List<ApiUser>
}