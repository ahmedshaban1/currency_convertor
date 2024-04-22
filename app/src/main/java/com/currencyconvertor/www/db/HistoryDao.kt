package com.currencyconvertor.www.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.currencyconvertor.www.data.history.model.History
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun addHistory(
    history: History,
  )

  @Query("SELECT * from history where timestamp < :startDate and timestamp >:endDate")
  fun getHistoryByDateRange(
    startDate: Long,
    endDate: Long,
  ): Flow<List<History>>
}
