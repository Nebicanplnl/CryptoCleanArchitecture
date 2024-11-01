package com.example.cryptocleanarchitecture.di

import com.example.cryptocleanarchitecture.data.remote.CryptoAPI
import com.example.cryptocleanarchitecture.data.repository.CryptoRepositoryImpl
import com.example.cryptocleanarchitecture.domain.repository.CryptoRepository
import com.example.cryptocleanarchitecture.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CryptoModule {

    @Singleton
    @Provides
    fun provideApi():CryptoAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(cryptoAPI: CryptoAPI): CryptoRepository {
        return CryptoRepositoryImpl(cryptoAPI)
    }
}