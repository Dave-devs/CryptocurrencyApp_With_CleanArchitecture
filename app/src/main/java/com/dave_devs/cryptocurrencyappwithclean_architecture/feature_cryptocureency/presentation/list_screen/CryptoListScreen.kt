package com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.presentation.list_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.util.Routes
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.presentation.list_screen.components.CryptoListItem

@Composable
fun CryptoListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: CryptoListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.coins) { coin ->
                CryptoListItem(
                    coin = coin,
                    onItemClick = {
                        navController.navigate(Routes.CRYPTO_DETAIL_SCREEN + "/${coin.coinId}")
                    }
                )
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}