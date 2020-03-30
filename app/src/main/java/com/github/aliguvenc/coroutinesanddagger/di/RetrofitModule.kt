package com.github.aliguvenc.coroutinesanddagger.di

import com.github.aliguvenc.coroutinesanddagger.BuildConfig
import com.github.aliguvenc.coroutinesanddagger.CustomInterceptor
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
abstract class RetrofitModule {

    @Binds
    abstract fun bindCustomInterceptor(customInterceptor: CustomInterceptor): Interceptor

    companion object {

        @Provides
        @Singleton
        fun provideOkHttp(
            httpLoggingInterceptor: HttpLoggingInterceptor,
            customInterceptor: CustomInterceptor
        ): OkHttpClient {
            return OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(customInterceptor)
                .build()
        }

        @Provides
        @Singleton
        fun provideLoggingInterceptor(): HttpLoggingInterceptor {
            return HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.BASIC
                }
            }
        }

        @Provides
        @Singleton
        fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.API_ADDRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

}