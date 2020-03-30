package com.github.aliguvenc.coroutinesanddagger.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.aliguvenc.coroutinesanddagger.ProductRepository
import com.github.aliguvenc.coroutinesanddagger.SecondViewModel
import dagger.Module
import dagger.Provides

@Module
abstract class SecondViewModelModule {

    companion object {

        @Provides
        fun provideMainViewModel(productRepository: ProductRepository): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return SecondViewModel(productRepository) as T
                }
            }
        }
    }

}