package com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.presentation.list_screen

import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.model.Coin

data class CryptoListState(
    val isLoading: Boolean = false,
    val error: String = "",
    val coins: List<Coin> = emptyList()
)
