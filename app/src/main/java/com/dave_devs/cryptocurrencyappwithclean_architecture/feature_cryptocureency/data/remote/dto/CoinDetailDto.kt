package com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.data.remote.dto

import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.model.CoinDetail
import com.google.gson.annotations.SerializedName

data class CoinDetailDto(
    @SerializedName("id")
    val coinId: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val description: String,
    val development_status: String,
    val first_data_at: String,
    val hardware_wallet: Boolean,
    val hash_algorithm: String,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("last_data_at")
    val lastDataAt: String,
    val links: Links,
    val links_extended: List<LinksExtended>,
    val logo: String,
    val message: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("org_structure")
    val orgStructure: String,
    @SerializedName("proof_type")
    val proofType: String,
    val started_at: String,
    val tags: List<Tag>,
    val team: List<TeamMember>,
    val type: String,
    @SerializedName("whitepaper")
    val whitePaper: Whitepaper
)

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = coinId,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name},
        team = team
    )
}
