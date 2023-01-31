package com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.data.remote.dto

import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.model.Coin
import com.google.gson.annotations.SerializedName

data class CoinDto(
    @SerializedName("id")
    val coinId: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        coinId = coinId,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}