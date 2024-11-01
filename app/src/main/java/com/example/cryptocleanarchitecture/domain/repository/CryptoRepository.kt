package com.example.cryptocleanarchitecture.domain.repository

import com.example.cryptocleanarchitecture.data.remote.dto.CryptoDto

interface CryptoRepository {
    suspend fun getCrypto(): CryptoDto
}