package com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.model

data class Coin(
    val coinId: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)
