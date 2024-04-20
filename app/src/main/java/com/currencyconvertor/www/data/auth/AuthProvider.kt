package com.currencyconvertor.www.data.auth

import com.currencyconvertor.www.remote.Constants.API_KEY
import com.currencyconvertor.www.remote.Constants.FORMAT

// mocking auth data source
class AuthProvider {
  fun getBasicQueryParams() =
    mutableMapOf<String, String>().apply {
      put(API_KEY, "529b61f533b034e3979f5e3b1ecbed16")
      put(FORMAT, "1")
    }
}
