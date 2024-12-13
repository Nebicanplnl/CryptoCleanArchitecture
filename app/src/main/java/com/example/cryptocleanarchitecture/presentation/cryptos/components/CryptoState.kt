package com.example.cryptocleanarchitecture.presentation.cryptos.components

import com.example.cryptocleanarchitecture.domain.model.Crypto

data class CryptoState(val isLoading: Boolean = false, val crypto: List<Crypto> = emptyList(), val error: String = "")
