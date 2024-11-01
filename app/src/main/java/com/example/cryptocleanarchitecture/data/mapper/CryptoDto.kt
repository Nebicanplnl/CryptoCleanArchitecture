package com.example.cryptocleanarchitecture.data.mapper

import com.example.cryptocleanarchitecture.data.remote.dto.CryptoDto
import com.example.cryptocleanarchitecture.domain.model.Crypto

// result.map ne işe yarar: result Listesindeki bütün indexleri dolaşıp iç kısımda yazılan işlemi bütün indexlere
// uygulayacak ve bu listenin uygulanmış halini bize geri vericek.
fun CryptoDto.toCrypto(): List<Crypto>{
    return result.map {
        Crypto(
            code = it.code,
            currency = it.currency,
            pricestr = it.pricestr
        )
    }
}