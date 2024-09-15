package com.example.myapiandoridapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Entity(
    val assetType: String,
    val ticker: String,
    val currentPrice: Double,
    val dividendYield: Double,
    val description: String
) : Parcelable

