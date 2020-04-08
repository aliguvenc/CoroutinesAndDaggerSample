package com.github.aliguvenc.coroutinesanddagger.di

import com.github.aliguvenc.coroutinesanddagger.SecondActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ProductModule::class, SecondViewModelModule::class])
interface SecondActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): SecondActivityComponent
    }

    fun inject(secondActivity: SecondActivity)
}