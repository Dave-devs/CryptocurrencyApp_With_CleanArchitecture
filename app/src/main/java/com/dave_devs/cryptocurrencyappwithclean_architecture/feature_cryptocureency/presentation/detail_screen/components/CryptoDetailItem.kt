package com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.presentation.detail_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.dave_devs.cryptocurrencyappwithclean_architecture.feature_cryptocureency.data.remote.dto.TeamMember

@Composable
fun CryptoDetailItem(
    modifier: Modifier = Modifier,
    teamMember: TeamMember
) {
   Column(modifier = modifier,
       verticalArrangement = Arrangement.Center
   ) {
       Text(
           text = teamMember.name,
           style = MaterialTheme.typography.headlineMedium
       )
       Spacer(Modifier.height(4.dp))
       Text(
           text = teamMember.position,
           style = MaterialTheme.typography.bodyMedium,
           fontStyle = FontStyle.Italic
       )
   }
}

