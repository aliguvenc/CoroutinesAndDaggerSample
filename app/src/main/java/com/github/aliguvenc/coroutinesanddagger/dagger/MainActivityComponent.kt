package com.github.aliguvenc.coroutinesanddagger.dagger

import com.github.aliguvenc.coroutinesanddagger.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [ProductModule::class, MainViewModelModule::class])
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)
}