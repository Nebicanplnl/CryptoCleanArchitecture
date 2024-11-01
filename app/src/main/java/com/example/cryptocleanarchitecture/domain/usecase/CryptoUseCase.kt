package com.example.cryptocleanarchitecture.domain.usecase

import com.example.cryptocleanarchitecture.data.mapper.toCrypto
import com.example.cryptocleanarchitecture.domain.model.Crypto
import com.example.cryptocleanarchitecture.domain.repository.CryptoRepository
import com.example.cryptocleanarchitecture.util.Resources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CryptoUseCase@Inject constructor(private val cryptoRepository: CryptoRepository)  {
    fun getCrypto(): Flow<Resources<List<Crypto>>> = flow {
        try {
            emit(Resources.Loading())
            val crypto = cryptoRepository.getCrypto()
            if (crypto.success) {
                emit(Resources.Success(crypto.toCrypto()))
            }else{
                emit(Resources.Error("No data"))

            }
        }catch (e: HttpException){
            emit(Resources.Error("$e.localizedMessage"))

        }catch (e: IOException){
            emit(Resources.Error("$e.localizedMessage"))
        }
    }
}