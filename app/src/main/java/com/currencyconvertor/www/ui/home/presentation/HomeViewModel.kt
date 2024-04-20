package com.currencyconvertor.www.ui.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.currencyconvertor.www.domian.usecases.GetCurrenciesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getCurrenciesUseCase: GetCurrenciesUseCase) : ViewModel() {

  init {
    viewModelScope.launch {
      getCurrenciesUseCase().collect {}
    }
  }
}
