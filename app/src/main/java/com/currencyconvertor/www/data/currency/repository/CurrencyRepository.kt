package com.currencyconvertor.www.data.currency.repository

import com.currencyconvertor.www.data.currency.datasource.CurrencyRemoteDS
import com.currencyconvertor.www.data.currency.models.CurrenciesResponse
import javax.inject.Inject

interface CurrencyRepository {
  suspend fun getCurrencies(): CurrenciesResponse
}

class CurrencyRepositoryImpl
@Inject
constructor(private val remote: CurrencyRemoteDS) :
  CurrencyRepository {
  override suspend fun getCurrencies() = remote.getCurrencies()
}
