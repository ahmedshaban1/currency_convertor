package com.currencyconvertor.www.ui.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.currencyconvertor.www.domian.usecases.GetCurrenciesUseCase
import com.currencyconvertor.www.entities.CurrencyEntity
import com.currencyconvertor.www.remote.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeState(
  val currencies: List<CurrencyEntity> = listOf(),
  val selectedCurrencyFrom: CurrencyEntity? = null,
  val selectedCurrencyTo: CurrencyEntity? = null,
  val currentFromValue: String = "1",
  val currentToValue: String = "",
) {
  fun isInputEnabled() = selectedCurrencyFrom != null && selectedCurrencyTo != null
}

@HiltViewModel
class HomeViewModel @Inject constructor(private val getCurrenciesUseCase: GetCurrenciesUseCase) : ViewModel() {
  private val _state = MutableStateFlow(HomeState())
  val state = _state.asStateFlow()

  init {
    getCurrencies()
  }

  private fun getCurrencies() {
    viewModelScope.launch {
      getCurrenciesUseCase().collect {
        when (it) {
          is Resource.Error -> TODO()
          is Resource.Success -> _state.emit(HomeState(currencies = it.data.currencies))
        }
      }
    }
  }

  private fun convertFromToTo() {
    if (_state.value.isInputEnabled()) {
      val fromRate = _state.value.selectedCurrencyFrom?.rate ?: 1f
      val toRate = _state.value.selectedCurrencyTo?.rate ?: 1f
      val rate = toRate / fromRate
      if (_state.value.currentFromValue.isEmpty()) return
      val toValue = rate * _state.value.currentFromValue.toFloat()
      _state.update {
        it.copy(
          currentToValue = "%.4f".format(toValue),
        )
      }
    }
  }

  private fun convertToToFrom() {
    if (_state.value.isInputEnabled()) {
      val fromRate = _state.value.selectedCurrencyFrom?.rate ?: 1f
      val toRate = _state.value.selectedCurrencyTo?.rate ?: 1f
      val rate = fromRate / toRate
      if (_state.value.currentToValue.isEmpty()) return
      val fromValue = rate * _state.value.currentToValue.toFloat()
      _state.update {
        it.copy(
          currentFromValue = "%.4f".format(fromValue),
        )
      }
    }
  }

  fun updateSelectedFromCurrency(
    selectedCurrencyFrom: CurrencyEntity,
  ) {
    _state.update {
      it.copy(
        selectedCurrencyFrom = selectedCurrencyFrom,
      )
    }
    convertFromToTo()
  }

  fun updateSelectedToCurrency(
    selectedCurrencyTo: CurrencyEntity,
  ) {
    _state.update {
      it.copy(
        selectedCurrencyTo = selectedCurrencyTo,
      )
    }
    convertFromToTo()
  }

  fun updateFromValue(
    value: String,
  ) {
    _state.update {
      it.copy(
        currentFromValue = value,
      )
    }
    convertFromToTo()
  }

  fun updateToValue(
    value: String,
  ) {
    _state.update {
      it.copy(
        currentToValue = value,
      )
    }
    convertToToFrom()
  }

  fun swipeValues() {
    val toValue = _state.value.currentToValue
    if (toValue.isBlank()) return
    _state.update {
      it.copy(currentFromValue = toValue)
    }
    convertFromToTo()
  }
}
