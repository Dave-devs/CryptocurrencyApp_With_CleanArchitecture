package com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.data.remote

import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.data.remote.dto.CoinDetailDto
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(
        @Path("coinId") coinId: String
    ): CoinDetailDto
}