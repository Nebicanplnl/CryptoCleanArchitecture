package com.example.cryptocleanarchitecture.data.remote

import com.example.cryptocleanarchitecture.data.remote.dto.CryptoDto
import com.example.cryptocleanarchitecture.util.Constants.API_KEY
import com.example.cryptocleanarchitecture.util.Constants.CONTENT_TYPE
import retrofit2.http.GET
import retrofit2.http.Header

interface CryptoAPI {
// @GET: Api'nin economy/cripto şu kısmına istek yollayıp cevapları istiyoruz ve oda bize cevapları döndürüyor.
    @GET("economy/cripto")
    suspend fun getCrypto(
        @Header("content-type") type: String = CONTENT_TYPE,
        @Header("authorization") key: String = API_KEY
    ): CryptoDto
}