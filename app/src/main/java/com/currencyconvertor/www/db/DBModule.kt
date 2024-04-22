package com.currencyconvertor.www.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

  @Provides
  @Singleton
  fun providesHistoryDataBase(
    @ApplicationContext context: Context,
  ): HistoryDatabase {
    return Room.databaseBuilder(
      context,
      HistoryDatabase::class.java,
      "history_db",
    ).build()
  }

  @Provides
  @Singleton
  fun providesHistoryDao(
    db: HistoryDatabase,
  ) = db.getHistoryDao()
}
