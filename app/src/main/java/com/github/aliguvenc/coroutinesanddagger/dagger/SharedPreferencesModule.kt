package com.github.aliguvenc.coroutinesanddagger.dagger

import android.content.Context
import com.github.aliguvenc.coroutinesanddagger.MyPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedPreferencesModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context) = MyPreferences(context)
}