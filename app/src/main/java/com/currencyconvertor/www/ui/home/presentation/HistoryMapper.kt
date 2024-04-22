package com.currencyconvertor.www.ui.home.presentation

import com.currencyconvertor.www.data.history.model.History
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// This mapping logic related to the view not the data layer

fun List<History>.toDaySections(): HashMap<String, List<History>> {
  val simpleDateFormat = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
  val results: HashMap<String, List<History>> = hashMapOf()
  forEach { historyItem ->
    val date = Date(historyItem.timestamp)
    val formatDate = simpleDateFormat.format(date)
    results[formatDate]?.let {
      val newList = it.toMutableList().apply {
        add(historyItem)
      }
      results[formatDate] = newList
    } ?: run {
      results[formatDate] = listOf(historyItem)
    }
  }
  return results
}
