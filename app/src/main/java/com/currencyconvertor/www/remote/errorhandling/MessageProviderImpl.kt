package com.currencyconvertor.www.remote.errorhandling

import android.content.res.Resources
import com.currencyconvertor.www.R
import com.currencyconvertor.www.remote.errorhandling.ErrorCodes.CONNECTION_ERROR
import com.currencyconvertor.www.remote.errorhandling.ErrorCodes.GENERIC_ERROR
import com.currencyconvertor.www.remote.errorhandling.ErrorCodes.NO_DATA_FOUND
import com.storytellerassignment.task.remote.errorhandling.MessageProvider

class MessageProviderImpl(private val res: Resources) : MessageProvider {
  override fun getMessage(
    errorCode: Int,
  ): String {
    return when (errorCode) {
      NO_DATA_FOUND -> res.getString(R.string.server_data_not_found)
      GENERIC_ERROR -> res.getString(R.string.generic_error)
      CONNECTION_ERROR -> res.getString(R.string.internet_error)
      else -> res.getString(R.string.generic_error)
    }
  }
}
