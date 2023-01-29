package com.rax.core.di

import com.rax.core.logging.Logger
import com.rax.core.logging.TimberLogs
import com.rax.core.usecase.UseCaseScheduler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    internal fun providePostScheduler() = AndroidSchedulers.mainThread()

    @Provides
    internal fun provideUseCaseScheduler(postScheduler: Scheduler) =
        UseCaseScheduler(Schedulers.io(), postScheduler)

    @Provides
    internal fun provideLogger(): Logger = object : Logger {
        override fun log(message: () -> String) {
            TimberLogs.d(message)
        }

        override fun logError(throwable: () -> Throwable) {
            TimberLogs.e(throwable)
        }
    }
}
