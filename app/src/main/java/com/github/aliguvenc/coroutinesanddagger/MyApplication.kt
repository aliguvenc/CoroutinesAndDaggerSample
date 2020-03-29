package com.github.aliguvenc.coroutinesanddagger

import android.app.Application
import com.github.aliguvenc.coroutinesanddagger.dagger.AppComponent
import com.github.aliguvenc.coroutinesanddagger.dagger.DaggerAppComponent

class MyApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().build()
    }
}