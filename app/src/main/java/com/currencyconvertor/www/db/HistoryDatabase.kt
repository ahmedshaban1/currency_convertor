package com.currencyconvertor.www.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.currencyconvertor.www.data.history.model.History

@Database(entities = [History::class], version = 1)
abstract class HistoryDatabase : RoomDatabase() {
  abstract fun getHistoryDao(): HistoryDao
}
