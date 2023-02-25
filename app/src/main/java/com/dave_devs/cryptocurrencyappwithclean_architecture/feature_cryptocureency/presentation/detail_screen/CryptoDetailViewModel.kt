package com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.presentation.detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dave_devs.cryptocurrencyappwithclean_architecture.common.Constant.COIN_ID
import com.dave_devs.cryptocurrencyappwithclean_architecture.common.Resource
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.use_cases.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(CryptoDetailState())
    val state: State<CryptoDetailState> = _state

    init {
        savedStateHandle.get<String>(COIN_ID)?.let { coinId->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId).onEach{ result ->
            when(result) {
                is Resource.Error -> {
                    _state.value = CryptoDetailState(isError = result.message?: "An unexpected error occurred")
                }
                is Resource.Success -> {
                    _state.value = CryptoDetailState(coin = result.data)
                }
                is Resource.Loading -> {
                    _state.value = CryptoDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}