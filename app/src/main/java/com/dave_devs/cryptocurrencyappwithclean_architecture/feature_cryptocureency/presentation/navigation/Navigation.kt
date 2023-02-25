package com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.presentation.detail_screen.CryptoDetailScreen
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.presentation.list_screen.CryptoListScreen
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.util.Routes

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Routes.CRYPTO_LIST_SCREEN
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Routes.CRYPTO_LIST_SCREEN) {
            CryptoListScreen(navController = navController)
        }
        composable(Routes.CRYPTO_DETAIL_SCREEN + "/{coinId}") {
            CryptoDetailScreen()
        }
    }
}