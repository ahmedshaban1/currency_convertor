package com.currencyconvertor.www.entities

// i don't want to use the sever model
data class CurrencyEntity(
  val name: String,
)

data class CurrenciesInfo(
  val currencies: List<CurrencyEntity> = listOf(),
)
