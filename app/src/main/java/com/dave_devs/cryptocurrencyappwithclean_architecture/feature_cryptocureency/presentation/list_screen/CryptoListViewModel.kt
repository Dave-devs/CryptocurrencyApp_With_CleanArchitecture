package com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.presentation.list_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dave_devs.cryptocurrencyappwithclean_architecture.common.Resource
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.use_cases.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
):ViewModel() {

    private val _state = mutableStateOf(CryptoListState())
    val state: State<CryptoListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result->
            when(result) {
                is Resource.Loading -> {
                    _state.value = CryptoListState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CryptoListState(coins = result.data ?: emptyList() )
                }
                is Resource.Error -> {
                    _state.value = CryptoListState(error = result.message ?: "An error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}