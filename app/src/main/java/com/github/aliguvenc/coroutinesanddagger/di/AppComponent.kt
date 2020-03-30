package com.github.aliguvenc.coroutinesanddagger.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [RetrofitModule::class, AppSubComponents::class]
)
@Singleton
interface AppComponent {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: Application): AppComponent
    }

    fun mainActivityComponent(): MainActivityComponent.Factory
    fun secondActivityComponent(): SecondActivityComponent.Factory
}