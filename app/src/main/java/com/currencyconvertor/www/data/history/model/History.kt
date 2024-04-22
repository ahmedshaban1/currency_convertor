package com.currencyconvertor.www.data.history.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("history")
data class History(
  @PrimaryKey(autoGenerate = true)
  val id: Int = 0,
  val fromCurrency: String,
  val fromRate: Float = 1f,
  val toCurrency: String,
  val toRate: Float,
  val timestamp: Long,
)
