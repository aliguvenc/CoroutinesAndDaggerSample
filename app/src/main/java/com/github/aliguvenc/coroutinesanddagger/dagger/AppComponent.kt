package com.github.aliguvenc.coroutinesanddagger.dagger

import dagger.Component
import javax.inject.Singleton

@Component(modules = [RetrofitModule::class])
@Singleton
interface AppComponent {

    fun getMainActivityComponent(): MainActivityComponent

    fun getSecondActivityComponent(): SecondActivityComponent

}