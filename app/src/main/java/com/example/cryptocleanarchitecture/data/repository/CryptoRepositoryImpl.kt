package com.example.cryptocleanarchitecture.data.repository

import com.example.cryptocleanarchitecture.data.remote.CryptoAPI
import com.example.cryptocleanarchitecture.data.remote.dto.CryptoDto
import com.example.cryptocleanarchitecture.domain.repository.CryptoRepository
import javax.inject.Inject

//bu repository usecase'e bağlanıcak asıl işlemi Api ile usecase'i birbirine bağlamak olacak.
class CryptoRepositoryImpl@Inject constructor(private val cryptoAPI: CryptoAPI): CryptoRepository {
    override suspend fun getCrypto(): CryptoDto {
        return cryptoAPI.getCrypto()
    }
}