package com.currencyconvertor.www.ui.common

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.currencyconvertor.www.entities.CurrencyEntity

@Composable
fun CurrencySelector(
  label: String,
  selectedCurrency: CurrencyEntity?,
  currencies: List<CurrencyEntity>,
  onSelectedCurrencyChanged: (CurrencyEntity) -> Unit,
) {
  var expanded by remember {
    mutableStateOf(false)
  }
  Box {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      Text(
        modifier = Modifier
          .clickable {
            expanded = !expanded
          }
          .border(
            1.dp,
            color = MaterialTheme.colorScheme.secondary,
          )
          .padding(
            horizontal = 8.dp,
            vertical = 4.dp,
          ),
        text = label,
        style = MaterialTheme.typography.headlineMedium,
      )
      Text(
        text = selectedCurrency?.name ?: "",
        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
      )
    }

    DropdownMenu(
      expanded = expanded,
      onDismissRequest = { expanded = false },
    ) {
      currencies.forEach {
        DropdownMenuItem(
          text = { Text(text = it.name) },
          onClick = {
            onSelectedCurrencyChanged(it)
            expanded = false
          },
        )
      }
    }
  }
}

@Preview
@Composable
fun CurrencySelectorPreview() {
  CurrencySelector("From", CurrencyEntity("USD", 1f), listOf(), { })
}
