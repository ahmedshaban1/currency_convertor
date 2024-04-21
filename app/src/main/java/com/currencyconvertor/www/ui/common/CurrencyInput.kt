package com.currencyconvertor.www.ui.common

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CurrencyInput(
  modifier: Modifier = Modifier,
  value: String,
  isInputEnabled: Boolean,
  onValueChanged: (String) -> Unit,
) {
  OutlinedTextField(
    modifier = modifier,
    value = value,
    enabled = isInputEnabled,
    onValueChange = onValueChanged,
    maxLines = 1,
    singleLine = true,
    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
    placeholder = { Text(text = "xxxx") },
  )
}
