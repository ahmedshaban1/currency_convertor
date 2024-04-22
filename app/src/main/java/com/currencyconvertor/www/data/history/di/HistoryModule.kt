package com.currencyconvertor.www.data.history.di

import com.currencyconvertor.www.data.history.datasource.local.HistoryLocalDataSource
import com.currencyconvertor.www.data.history.datasource.local.HistoryLocalDataSourceImpl
import com.currencyconvertor.www.data.history.repository.HistoryRepository
import com.currencyconvertor.www.data.history.repository.HistoryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class HistoryModule {

  @Binds
  @Singleton
  abstract fun bindsHistoryLocalDatasource(
    historyLocalDataSource: HistoryLocalDataSourceImpl,
  ): HistoryLocalDataSource

  @Binds
  @Singleton
  abstract fun bindsHistoryRepository(
    historyRepository: HistoryRepositoryImpl,
  ): HistoryRepository
}
