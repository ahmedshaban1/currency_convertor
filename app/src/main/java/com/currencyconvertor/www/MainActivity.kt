package com.currencyconvertor.www

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.currencyconvertor.www.ui.details.DetailsScreen
import com.currencyconvertor.www.ui.theme.CurrencyConvertorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(
    savedInstanceState: Bundle?,
  ) {
    super.onCreate(savedInstanceState)
    setContent {
      CurrencyConvertorTheme {
        DetailsScreen()
      }
    }
  }
}
