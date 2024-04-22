package com.currencyconvertor.www.ui.details

import android.util.Log
import androidx.lifecycle.ViewModel
import com.currencyconvertor.www.data.history.model.History
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Calendar
import javax.inject.Inject

data class DetailsState(
  val history: HashMap<String, List<History>> = hashMapOf(),
)

@HiltViewModel
class DetailsViewModel @Inject constructor() : ViewModel() {
  private val _state = MutableStateFlow(DetailsState())
  val state = _state.asStateFlow()

  init {
    getHistory()
  }

  private fun getHistory() {
    val startDate = System.currentTimeMillis()
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DATE, -3)
    val endDate = calendar.time.time
  }
}
