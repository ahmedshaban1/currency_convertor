package com.currencyconvertor.www.ui.details

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsScreen(
  viewModel: DetailsViewModel = hiltViewModel(),
) {
  Scaffold {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LazyColumn {
      state.historyData.forEach {
        item {
          Text(text = it.key)
        }
        items(it.value) {
          Text(text = it.fromCurrency)
        }
      }
    }
  }
}
