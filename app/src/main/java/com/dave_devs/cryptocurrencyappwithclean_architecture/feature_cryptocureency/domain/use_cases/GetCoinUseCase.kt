package com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.use_cases

import com.dave_devs.cryptocurrencyappwithclean_architecture.common.Resource
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.data.remote.dto.toCoinDetail
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.model.CoinDetail
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
){
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = coinRepository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (_: HttpException) {
            emit(Resource.Error("The server could not process the request due to invalid " +
                    "request parameters or invalid format of the parameters."))
        } catch (_: IOException) {
            emit(Resource.Error("An unexpected server error has occurred."))
        }
    }
}