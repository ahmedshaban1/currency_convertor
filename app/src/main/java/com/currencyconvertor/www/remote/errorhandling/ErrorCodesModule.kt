package com.currencyconvertor.www.remote.errorhandling

import android.content.Context
import com.storytellerassignment.task.remote.errorhandling.MessageProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ErrorCodesModule {
  @Provides
  @Singleton
  fun providesErrorCodes(
    @ApplicationContext context: Context,
  ): MessageProvider = MessageProviderImpl(context.resources)
}
