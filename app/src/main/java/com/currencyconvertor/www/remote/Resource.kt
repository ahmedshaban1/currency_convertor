package com.currencyconvertor.www.remote

sealed class Resource<out T> {
  class Error(val errorCode: Int) : Resource<Nothing>()

  class Success<out T>(val data: T, val dataSource: DataSource = DataSource.REMOTE) : Resource<T>()
}

// you can add more data sources here
enum class DataSource {
  REMOTE,
}
