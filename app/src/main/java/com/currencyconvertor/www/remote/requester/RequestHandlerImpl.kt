package com.currencyconvertor.www.remote.requester

import com.currencyconvertor.www.remote.ResultWrapper
import com.currencyconvertor.www.remote.errorhandling.ErrorCodes
import com.currencyconvertor.www.remote.errorhandling.ErrorCodes.CONNECTION_ERROR
import com.currencyconvertor.www.remote.errorhandling.ErrorCodes.ERROR_TIME_OUT
import com.currencyconvertor.www.remote.errorhandling.ErrorCodes.GENERIC_ERROR
import com.storytellerassignment.task.remote.requester.RequestHandler
import kotlinx.coroutines.TimeoutCancellationException
import retrofit2.HttpException
import java.io.IOException

class RequestHandlerImpl : RequestHandler {
  override suspend fun <T> makeApiRequest(
    call: suspend () -> T?,
  ): ResultWrapper<T> {
    return try {
      call.invoke()?.let {
        ResultWrapper.Success(it)
      } ?: kotlin.run {
        ResultWrapper.GenericError(ErrorCodes.NO_DATA_FOUND)
      }
    } catch (throwable: Throwable) {
      throwable.printStackTrace()
      when (throwable) {
        is TimeoutCancellationException -> {
          ResultWrapper.GenericError(ERROR_TIME_OUT)
        }
        is IOException -> {
          ResultWrapper.GenericError(
            CONNECTION_ERROR,
          )
        }
        is HttpException -> {
          ResultWrapper.GenericError(
            errorCode = throwable.response()?.code() ?: GENERIC_ERROR,
          )
        }
        else -> {
          ResultWrapper.GenericError(GENERIC_ERROR)
        }
      }
    }
  }
}
