package com.github.aliguvenc.coroutinesanddagger.di

import com.github.aliguvenc.coroutinesanddagger.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ProductModule::class, MainViewModelModule::class])
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainActivityComponent
    }

    fun inject(mainActivity: MainActivity)
}