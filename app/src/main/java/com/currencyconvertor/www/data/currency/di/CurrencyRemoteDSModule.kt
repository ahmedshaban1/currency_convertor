package com.currencyconvertor.www.data.currency.di

import com.currencyconvertor.www.data.currency.datasource.CurrencyRemoteDS
import com.currencyconvertor.www.data.currency.datasource.CurrencyRemoteDSImpl
import com.currencyconvertor.www.data.currency.repository.CurrencyRepository
import com.currencyconvertor.www.data.currency.repository.CurrencyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class CurrencyRemoteDSModule {
  @Binds
  @Singleton
  abstract fun bindsClipRemoteDS(
    impl: CurrencyRemoteDSImpl,
  ): CurrencyRemoteDS

  @Binds
  @Singleton
  abstract fun bindsClipRepository(
    impl: CurrencyRepositoryImpl,
  ): CurrencyRepository
}
