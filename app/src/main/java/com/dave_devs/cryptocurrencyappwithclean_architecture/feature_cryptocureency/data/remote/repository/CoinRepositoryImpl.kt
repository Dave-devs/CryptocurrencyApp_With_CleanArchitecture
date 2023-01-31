package com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.data.remote.repository

import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.data.remote.CoinPaprikaApi
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.data.remote.dto.CoinDetailDto
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.data.remote.dto.CoinDto
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
       return api.getCoinById(coinId)
    }
}