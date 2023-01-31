package com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.repository

import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.data.remote.dto.CoinDetailDto
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}