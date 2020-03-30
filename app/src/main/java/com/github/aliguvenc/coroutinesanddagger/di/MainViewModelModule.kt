package com.github.aliguvenc.coroutinesanddagger.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.aliguvenc.coroutinesanddagger.MainViewModel
import com.github.aliguvenc.coroutinesanddagger.ProductRepository
import dagger.Module
import dagger.Provides

@Module
abstract class MainViewModelModule {

    companion object {

        @Provides
        fun provideMainViewModel(productRepository: ProductRepository): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return MainViewModel(productRepository) as T
                }
            }
        }
    }

}