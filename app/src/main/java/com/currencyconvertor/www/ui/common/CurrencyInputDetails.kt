package com.currencyconvertor.www.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.currencyconvertor.www.entities.CurrencyEntity

@Composable
fun CurrencyInputDetails(
  inputName: String,
  selectedCurrency: CurrencyEntity?,
  defaultValue: String,
  currencies: List<CurrencyEntity>,
  isInputEnabled: Boolean = false,
  onValueChanged: (String) -> Unit,
  onSelectedCurrencyChanged: (CurrencyEntity) -> Unit,
) {
  Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
    CurrencySelector(
      inputName,
      selectedCurrency,
      currencies,
      onSelectedCurrencyChanged,
    )
    CurrencyInput(
      Modifier.width(150.dp),
      defaultValue,
      isInputEnabled,
      onValueChanged,
    )
  }
}
