package com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.presentation.detail_screen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CryptoDetailTag(
    modifier: Modifier = Modifier,
    tag: String
) {
    Box(modifier = modifier
        .padding(10.dp)
        .border(
            width = 1.dp,
            shape = RoundedCornerShape(100.dp),
            color = MaterialTheme.colorScheme.primary
        )
    ) {
        Text(
            text = tag,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall
        )
    } 
}