package com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.presentation.list_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.domain.model.Coin

@Composable
fun CryptoListItem(
    modifier: Modifier = Modifier,
    coin: Coin,
    onItemClick: (Coin) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable { onItemClick(coin) },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Card(modifier = Modifier
            .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onBackground
            )
        ) {
            Text(
                text = "${coin.rank}. ${coin.name} (&{coin.symbol})",
                style = MaterialTheme.typography.bodySmall,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = if (coin.isActive) "active" else "inactive",
                color = if (coin.isActive) Color.Green else Color.Red,
                style = MaterialTheme.typography.bodyMedium,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.End
            )
        }
    }
}
