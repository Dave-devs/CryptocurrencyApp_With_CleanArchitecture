package com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.use_cases

import com.dave_devs.cryptocurrencyappwithclean_architecture.common.Resource
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.data.remote.dto.toCoin
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.model.Coin
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class GetCoinsUseCase(
    private val coinRepository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = coinRepository.getCoins().map {it.toCoin()}
            emit(Resource.Success(coins))
        } catch (_: HttpException) {
            emit(Resource.Error("The server could not process the request due to invalid " +
                    "request parameters or invalid format of the parameters."))
        } catch (_: IOException) {
            emit(Resource.Error("An unexpected server error has occurred."))
        }
    }
}