package com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.presentation.detail_screen

import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.model.CoinDetail

data class CryptoDetailState(
    val isLoading: Boolean = false,
    val isError: String = "",
    val coin: CoinDetail? = null
)
