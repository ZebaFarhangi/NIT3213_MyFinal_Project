package com.example.myapiandoridapp.data.api

interface ApiService {
    @POST("/ort/auth")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @GET("/dashboard/investments")
    suspend fun getDashboard(@Header("Authorization") keypass: String): List<Entity>
}