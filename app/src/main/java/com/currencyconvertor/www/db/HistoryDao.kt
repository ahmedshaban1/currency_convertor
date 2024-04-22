package com.currencyconvertor.www.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.currencyconvertor.www.data.history.model.History

@Dao
interface HistoryDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun addHistory(
    history: History,
  )
  // fun getHistoryByDateRange(): Flow<History>
}
