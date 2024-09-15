package com.example.myapiandoridapp.data.repository

import com.example.myapiandoridapp.data.api.ApiService
import com.example.myapiandoridapp.data.model.Entity
import com.example.myapiandoridapp.data.model.LoginRequest
import javax.inject.Inject

class InvestmentRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun login(username: String, password: String): Result<String> {
        return try {
            val response = apiService.login(LoginRequest(username, password))
            Result.success(response.keypass)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    suspend fun getDashboard(keypass: String): Result<List<Entity>> {
        return try {
            val entities = apiService.getDashboard("Bearer $keypass")
            Result.success(entities)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

