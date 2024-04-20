package com.currencyconvertor.www.data.currency.datasource

import com.currencyconvertor.www.data.currency.CurrenciesApiService
import com.currencyconvertor.www.data.currency.models.CurrenciesResponse
import javax.inject.Inject

// in our case DS is not important but i just developed it just for demonstration
interface CurrencyRemoteDS {
  suspend fun getCurrencies(): CurrenciesResponse
}

class CurrencyRemoteDSImpl
@Inject
constructor(private val apiService: CurrenciesApiService) : CurrencyRemoteDS {
  override suspend fun getCurrencies() = apiService.getCurrencies()
}
