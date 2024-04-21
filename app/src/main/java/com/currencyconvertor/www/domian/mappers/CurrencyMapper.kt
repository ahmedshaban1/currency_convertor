package com.currencyconvertor.www.domian.mappers

import com.currencyconvertor.www.data.currency.models.CurrenciesResponse
import com.currencyconvertor.www.entities.CurrenciesInfo
import com.currencyconvertor.www.entities.CurrencyEntity
import com.google.gson.JsonObject

fun CurrenciesResponse.toCurrenciesInfo(): CurrenciesInfo {
  return CurrenciesInfo(
    currencies = rates.toCurrencyEntity(),
  )
}

fun JsonObject.toCurrencyEntity(): List<CurrencyEntity> {
  return this.asMap().map {
    CurrencyEntity(name = it.key, it.value.asFloat)
  }
}
