package com.storytellerassignment.task.remote.errorhandling

interface MessageProvider {
  fun getMessage(
    errorCode: Int,
  ): String
}
