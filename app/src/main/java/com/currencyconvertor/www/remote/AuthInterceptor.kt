package com.currencyconvertor.www.remote

import com.currencyconvertor.www.data.auth.AuthProvider
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor
@Inject
constructor(private val authProvider: AuthProvider) : Interceptor {
  override fun intercept(
    chain: Interceptor.Chain,
  ): Response {
    var request: Request = chain.request()
    val url: HttpUrl =
      request.url.newBuilder().apply {
        authProvider.getBasicQueryParams().forEach { (key, value) ->
          addQueryParameter(key, value)
        }
      }.build()
    request = request.newBuilder().url(url).build()
    return chain.proceed(request)
  }
}
