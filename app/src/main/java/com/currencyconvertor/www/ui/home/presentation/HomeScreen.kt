package com.currencyconvertor.www.ui.home.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.currencyconvertor.www.R
import com.currencyconvertor.www.ui.common.CurrencyInputDetails

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
  viewModel: HomeViewModel = hiltViewModel(),
) {
  val state by viewModel.state.collectAsStateWithLifecycle()
  Scaffold {
    Box(
      modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.Center,
    ) {
      Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
      ) {
        CurrencyInputDetails(
          stringResource(id = R.string.from),
          state.selectedCurrencyFrom,
          state.currentFromValue,
          state.currencies,
          state.isInputEnabled(),
          onValueChanged = {
            viewModel.updateFromValue(it)
          },
        ) {
          viewModel.updateSelectedFromCurrency(it)
        }

        IconButton(onClick = { viewModel.swipeValues() }) {
          Icon(
            painter = painterResource(id = R.drawable.baseline_compare_arrows_24),
            contentDescription = "",
          )
        }
        CurrencyInputDetails(
          stringResource(id = R.string.to),
          state.selectedCurrencyTo,
          state.currentToValue,
          state.currencies,
          state.isInputEnabled(),
          onValueChanged = {
            viewModel.updateToValue(it)
          },
        ) {
          viewModel.updateSelectedToCurrency(it)
        }
      }
    }
  }
}
