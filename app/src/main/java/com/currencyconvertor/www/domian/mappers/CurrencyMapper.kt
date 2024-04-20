package com.currencyconvertor.www.domian.mappers

import com.currencyconvertor.www.data.currency.models.CurrenciesResponse
import com.currencyconvertor.www.data.currency.models.Currency
import com.currencyconvertor.www.entities.CurrenciesInfo
import com.currencyconvertor.www.entities.CurrencyEntity

fun CurrenciesResponse.toCurrenciesInfo(): CurrenciesInfo {
  return CurrenciesInfo(
    currencies = currencies.toCurrencyEntity(),
  )
}

fun List<Currency>.toCurrencyEntity() =
  map { currency ->
    CurrencyEntity(
      name = currency.name,
    )
  }
