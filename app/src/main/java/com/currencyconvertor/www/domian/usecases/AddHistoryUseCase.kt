package com.currencyconvertor.www.domian.usecases

import com.currencyconvertor.www.data.history.model.History
import com.currencyconvertor.www.data.history.repository.HistoryRepository
import javax.inject.Inject

class AddHistoryUseCase @Inject constructor(private val repository: HistoryRepository) {
  suspend operator fun invoke(
    history: History,
  ) {
    repository.addHistory(history = history)
  }
}
