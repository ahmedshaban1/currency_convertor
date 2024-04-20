package com.currencyconvertor.www.remote

import com.currencyconvertor.www.data.auth.AuthProvider
import com.currencyconvertor.www.data.currency.CurrenciesApiService
import com.currencyconvertor.www.remote.Constants.BASE_URL
import com.currencyconvertor.www.remote.requester.RequestHandlerImpl
import com.google.gson.GsonBuilder
import com.storytellerassignment.task.remote.requester.RequestHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RemoteModule {
  @Singleton
  @Provides
  fun providesRetrofit(
    okHttpClient: OkHttpClient,
  ): Retrofit {
    val gson =
      GsonBuilder()
        .setLenient()
        .create()
    return Retrofit.Builder()
      .client(okHttpClient)
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create(gson))
      .build()
  }

  @Singleton
  @Provides
  fun providesClient(
    authInterceptor: AuthInterceptor,
    logger: Interceptor,
  ): OkHttpClient {
    return OkHttpClient.Builder()
      .addInterceptor(authInterceptor)
      .addInterceptor(logger)
      .build()
  }

  @Singleton
  @Provides
  fun providesAuthProvider() = AuthProvider()

  @Provides
  @Singleton
  fun provideLoggingInterceptor(): Interceptor {
    return HttpLoggingInterceptor()
      .setLevel(HttpLoggingInterceptor.Level.BODY)
  }

  @Provides
  @Singleton
  fun providesRequestHandler(): RequestHandler = RequestHandlerImpl()

  @Provides
  @Singleton
  fun providesReelsApiService(
    retrofit: Retrofit,
  ): CurrenciesApiService {
    return retrofit.create(CurrenciesApiService::class.java)
  }
}
