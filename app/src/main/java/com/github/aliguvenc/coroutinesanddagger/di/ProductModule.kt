package com.github.aliguvenc.coroutinesanddagger.di

import com.github.aliguvenc.coroutinesanddagger.PhotosApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class ProductModule {

    @ActivityScope
    @Provides
    fun provideProductApi(retrofit: Retrofit): PhotosApi = retrofit.create(
        PhotosApi::class.java
    )

}
