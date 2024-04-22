package com.currencyconvertor.www.domian.usecases

import com.currencyconvertor.www.data.history.repository.HistoryRepository
import javax.inject.Inject

class GetHistoryUseCase @Inject constructor(private val repository: HistoryRepository) {
  suspend operator fun invoke(
    startDate: Long,
    endDate: Long,
  ) = repository.getHistory(startDate, endDate)
}
