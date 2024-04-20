package com.storytellerassignment.task.remote.requester

import com.currencyconvertor.www.remote.ResultWrapper

interface RequestHandler {
  suspend fun <T> makeApiRequest(
    call: suspend () -> T?,
  ): ResultWrapper<T>
}
