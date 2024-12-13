package com.example.cryptocleanarchitecture.presentation.cryptos.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocleanarchitecture.domain.usecase.CryptoUseCase
import com.example.cryptocleanarchitecture.util.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(
    private val cryptoUseCase: CryptoUseCase
): ViewModel() {

    private val _cryptoState = mutableStateOf(CryptoState())
    val cryptoState: State<CryptoState> = _cryptoState

    init {
        getCrypto()
    }

    private var job: Job? = null

    private fun getCrypto() {
        job?.cancel()
       job = cryptoUseCase.getCrypto().onEach {
            when(it) {
                is Resources.Success -> {
                    _cryptoState.value = CryptoState(crypto = it.data ?: emptyList())
                }
                is Resources.Error -> {
                    _cryptoState.value = CryptoState(error = it.message ?: "Error!")
            }
                is Resources.Loading -> {
                    _cryptoState.value = CryptoState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}