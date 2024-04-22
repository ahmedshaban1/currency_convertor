package com.currencyconvertor.www.data.history.repository

import com.currencyconvertor.www.data.history.datasource.local.HistoryLocalDataSource
import com.currencyconvertor.www.data.history.model.History
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface HistoryRepository {
  suspend fun addHistory(
    history: History,
  )
  suspend fun getHistory(
    startDate: Long,
    endDate: Long,
  ): Flow<List<History>>
}

class HistoryRepositoryImpl @Inject constructor(private val localDataSource: HistoryLocalDataSource) :
  HistoryRepository {
  override suspend fun addHistory(
    history: History,
  ) = withContext(Dispatchers.IO) {
    localDataSource.addHistory(history = history)
  }

  override suspend fun getHistory(
    startDate: Long,
    endDate: Long,
  ) = localDataSource.getHistory(startDate, endDate)
}
