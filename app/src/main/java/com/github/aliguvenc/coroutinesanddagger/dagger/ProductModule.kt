package com.github.aliguvenc.coroutinesanddagger.dagger

import com.github.aliguvenc.coroutinesanddagger.ProductApi
import com.github.aliguvenc.coroutinesanddagger.ProductRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class ProductModule {

    companion object {
        @Provides
        fun provideProductApi(retrofit: Retrofit): ProductApi = retrofit.create(
            ProductApi::class.java
        )

        @Provides
        fun provideProductRepository(productApi: ProductApi): ProductRepository =
            ProductRepository(productApi)

    }

}
