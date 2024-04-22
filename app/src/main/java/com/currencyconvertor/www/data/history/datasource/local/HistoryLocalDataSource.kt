package com.currencyconvertor.www.data.history.datasource.local

import com.currencyconvertor.www.data.history.model.History
import com.currencyconvertor.www.db.HistoryDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface HistoryLocalDataSource {
  suspend fun addHistory(
    history: History,
  )
  suspend fun getHistory(
    startDate: Long,
    endDate: Long,
  ): Flow<List<History>>
}

class HistoryLocalDataSourceImpl @Inject constructor(private val dao: HistoryDao) : HistoryLocalDataSource {
  override suspend fun addHistory(
    history: History,
  ) {
    dao.addHistory(history = history)
  }

  override suspend fun getHistory(
    startDate: Long,
    endDate: Long,
  ): Flow<List<History>> {
    val date = dao.getHistoryByDateRange(startDate, endDate)
    return date
  }
}
