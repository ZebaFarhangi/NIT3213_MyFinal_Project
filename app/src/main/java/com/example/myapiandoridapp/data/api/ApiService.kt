package com.example.myapiandoridapp.data.api

import com.example.myapiandoridapp.data.model.Entity
import com.example.myapiandoridapp.data.model.LoginRequest
import com.example.myapiandoridapp.data.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("/ort/auth")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @GET("/dashboard/investments")
    suspend fun getDashboard(@Header("Authorization") keypass: String): List<Entity>
}