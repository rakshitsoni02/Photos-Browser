package com.rax.core.di

import com.rax.core.BuildConfig
import com.rax.core.convertor.DateTimeMoshiAdapter
import com.rax.core.convertor.LocalDateTimeMoshiAdapter
import com.rax.core.repository.ApiService
import com.rax.core.repository.HttpRequestFactory
import com.rax.core.repository.HttpRequestFactoryType
import com.rax.core.repository.StringConverterFactory
import com.rax.core.repository.intercepters.ApiRequestInterceptor
import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

internal const val TIMEOUT_DEFAULT = 15L
internal val TIMEOUT_TIME_UNIT = TimeUnit.SECONDS

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    internal fun provideOkHttpClient(
        apiRequestInterceptor: ApiRequestInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val client = OkHttpClient.Builder()

        client.connectTimeout(TIMEOUT_DEFAULT, TIMEOUT_TIME_UNIT)
        client.readTimeout(TIMEOUT_DEFAULT, TIMEOUT_TIME_UNIT)
        client.writeTimeout(TIMEOUT_DEFAULT, TIMEOUT_TIME_UNIT)
        client.addInterceptor(apiRequestInterceptor)

        val protocols = arrayListOf(
            Protocol.HTTP_2,
            Protocol.HTTP_1_1
        )
        client.protocols(protocols)

        if (BuildConfig.DEBUG) {
            client.addInterceptor(httpLoggingInterceptor)
        }
        return client.build()
    }

    @Provides
    @Singleton
    internal fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        val rxAdapter = RxJava3CallAdapterFactory.create()
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL_API)
            .addConverterFactory(StringConverterFactory())
            .addCallAdapterFactory(rxAdapter)
            .build()
    }

    @Provides
    @Singleton
    internal fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface NetworkAbstractModule {
        @Binds
        fun bindHttpRequestFactoryType(impl: HttpRequestFactory): HttpRequestFactoryType
    }

    @Provides
    @Singleton
    internal fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(LocalDateTimeMoshiAdapter())
            .add(DateTimeMoshiAdapter())
            .build()
    }

}