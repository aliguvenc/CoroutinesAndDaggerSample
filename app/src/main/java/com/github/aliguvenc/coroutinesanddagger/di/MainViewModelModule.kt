package com.github.aliguvenc.coroutinesanddagger.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.aliguvenc.coroutinesanddagger.MainViewModel
import com.github.aliguvenc.coroutinesanddagger.PhotoRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainVieModel(mainViewModel: MainViewModel): ViewModel

}