package com.example.cryptocleanarchitecture.presentation.cryptos

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptocleanarchitecture.presentation.cryptos.components.CryptoItem
import com.example.cryptocleanarchitecture.presentation.cryptos.components.CryptoViewModel

@Composable
fun CryptoFun(
    cryptoViewModel: CryptoViewModel = hiltViewModel()
) {
    val state = cryptoViewModel.cryptoState.value

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn {
            items(state.crypto) { crypto ->
                CryptoItem(crypto)
                HorizontalDivider()
            }
        }
        if (state.error.isNotBlank()) {
            Text(text = state.error,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.fillMaxSize()
                    .padding( 20.dp)
                    .align(Alignment.Center))
        }
        if (state.isLoading) {
            CircularProgressIndicator()
        }
    }
}