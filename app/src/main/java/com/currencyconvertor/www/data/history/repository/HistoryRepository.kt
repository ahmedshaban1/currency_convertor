package com.currencyconvertor.www.data.history.repository

import com.currencyconvertor.www.data.history.datasource.local.HistoryLocalDataSource
import com.currencyconvertor.www.data.history.model.History
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface HistoryRepository {
  suspend fun addHistory(
    history: History,
  )
}

class HistoryRepositoryImpl @Inject constructor(private val localDataSource: HistoryLocalDataSource) :
  HistoryRepository {
  override suspend fun addHistory(
    history: History,
  ) = withContext(Dispatchers.IO) {
    localDataSource.addHistory(history = history)
  }
}
