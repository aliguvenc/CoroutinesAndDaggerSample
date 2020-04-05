package com.github.aliguvenc.coroutinesanddagger.dagger

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppContextModule(private val context: Application) {

    @Provides
    fun provideAppContext(): Context = context.applicationContext

}