package com.currencyconvertor.www.data.history.datasource.local

import com.currencyconvertor.www.data.history.model.History
import com.currencyconvertor.www.db.HistoryDao
import javax.inject.Inject

interface HistoryLocalDataSource {
  suspend fun addHistory(
    history: History,
  )
}

class HistoryLocalDataSourceImpl @Inject constructor(private val dao: HistoryDao) : HistoryLocalDataSource {
  override suspend fun addHistory(
    history: History,
  ) {
    dao.addHistory(history = history)
  }
}
