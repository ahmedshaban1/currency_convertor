package com.currencyconvertor.www.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.currencyconvertor.www.data.history.model.History
import com.currencyconvertor.www.domian.usecases.GetHistoryUseCase
import com.currencyconvertor.www.ui.home.presentation.toDaySections
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

data class DetailsState(
  val historyData: HashMap<String, List<History>> = hashMapOf(),
)

@HiltViewModel
class DetailsViewModel @Inject constructor(private val getHistoryUseCase: GetHistoryUseCase) : ViewModel() {
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
    viewModelScope.launch {
      getHistoryUseCase(startDate, endDate).collect {
        _state.emit(DetailsState(it.toDaySections()))
      }
    }
  }
}
