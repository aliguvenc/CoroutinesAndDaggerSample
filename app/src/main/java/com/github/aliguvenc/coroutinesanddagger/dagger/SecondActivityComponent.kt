package com.github.aliguvenc.coroutinesanddagger.dagger

import com.github.aliguvenc.coroutinesanddagger.SecondActivity
import dagger.Subcomponent

@Subcomponent(modules = [ProductModule::class, SecondViewModelModule::class])
interface SecondActivityComponent {

    fun inject(secondActivity: SecondActivity)
}