package com.github.aliguvenc.coroutinesanddagger.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.aliguvenc.coroutinesanddagger.PhotoRepository
import com.github.aliguvenc.coroutinesanddagger.SecondViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class SecondViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SecondViewModel::class)
    abstract fun bindSecondViewModel(secondViewModel: SecondViewModel): ViewModel

}