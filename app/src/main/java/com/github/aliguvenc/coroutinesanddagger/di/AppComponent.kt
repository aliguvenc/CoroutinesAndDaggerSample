package com.github.aliguvenc.coroutinesanddagger.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [RetrofitModule::class, AppSubComponents::class, AppDataModule::class, ViewModelFactoryModule::class]
)
@Singleton
interface AppComponent {

    @Component.Factory
    interface Factory {

        /**
         * @param context Dagger graph içerisinde [context] gereken yerlerde kullanmak için
         */
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun mainActivityComponent(): MainActivityComponent.Factory
    fun secondActivityComponent(): SecondActivityComponent.Factory
}