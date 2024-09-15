package com.example.myapiandoridapp.data.model

data class Entity(
    val assetType: String,
    val ticker: String,
    val currentPrice: Double,
    val dividendYield: Double,
    val description: String
)