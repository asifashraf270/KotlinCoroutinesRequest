package com.example.kotlincoroutines.network

import com.example.kotlincoroutines.model.ApiUser

class ApiHelperImp(private val apiService: ApiService):ApiHelper {
    override suspend fun getUser(): List<ApiUser> {
        return apiService.getUsers()
    }

    override suspend fun getMoreUser(): List<ApiUser> {
        return apiService.getMoreUsers()
    }
}