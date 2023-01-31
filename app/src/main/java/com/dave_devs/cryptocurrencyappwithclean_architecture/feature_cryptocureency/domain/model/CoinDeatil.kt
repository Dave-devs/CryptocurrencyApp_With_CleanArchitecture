package com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.model

import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.data.remote.dto.*

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>,
)
