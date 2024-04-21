package com.currencyconvertor.www.data.currency.models

import com.google.gson.JsonObject

data class CurrenciesResponse(
  val success: Boolean,
  val rates: JsonObject,
)
