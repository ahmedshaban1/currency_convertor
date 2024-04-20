package com.currencyconvertor.www.domian.usecases

import com.currencyconvertor.www.data.currency.repository.CurrencyRepository
import com.currencyconvertor.www.domian.mappers.toCurrenciesInfo
import com.currencyconvertor.www.remote.Resource
import com.currencyconvertor.www.remote.ResultWrapper
import com.storytellerassignment.task.remote.requester.RequestHandler
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCurrenciesUseCase
@Inject
constructor(
  private val repository: CurrencyRepository,
  private val requestHandler: RequestHandler,
) : RequestHandler by requestHandler {
  suspend operator fun invoke() =
    flow {
      val results =
        requestHandler.makeApiRequest {
          repository.getCurrencies()
        }
      when (results) {
        is ResultWrapper.GenericError -> emit(Resource.Error(results.errorCode))
        is ResultWrapper.Success -> emit(Resource.Success(results.value.toCurrenciesInfo()))
      }
    }
}
