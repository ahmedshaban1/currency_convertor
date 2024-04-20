package com.currencyconvertor.www.data.currency

import com.currencyconvertor.www.data.currency.models.CurrenciesResponse
import retrofit2.http.GET

interface CurrenciesApiService {
  @GET("latest")
  suspend fun getCurrencies(): CurrenciesResponse
}
