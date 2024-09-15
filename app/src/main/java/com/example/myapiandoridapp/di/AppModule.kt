package com.example.myapiandoridapp.di

import com.example.myapiandoridapp.data.api.ApiService
import com.example.myapiandoridapp.data.repository.InvestmentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://vu-nit3213-api.onrender.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideInvestmentRepository(apiService: ApiService): InvestmentRepository {
        return InvestmentRepository(apiService)
    }
}