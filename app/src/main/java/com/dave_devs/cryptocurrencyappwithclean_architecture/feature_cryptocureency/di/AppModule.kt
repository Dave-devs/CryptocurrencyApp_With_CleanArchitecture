package com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.di

import com.dave_devs.cryptocurrencyappwithclean_architecture.common.Constant.BASE_URL
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.data.remote.CoinPaprikaApi
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.data.remote.repository.CoinRepositoryImpl
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.repository.CoinRepository
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.use_cases.GetCoinUseCase
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.use_cases.GetCoinsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinPaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCryptoRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetCoinsUseCase(repository: CoinRepository): GetCoinsUseCase {
        return GetCoinsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetCoinUseCase(repository: CoinRepository): GetCoinUseCase {
        return GetCoinUseCase(repository)
    }
}