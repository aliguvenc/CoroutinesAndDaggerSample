package com.github.aliguvenc.coroutinesanddagger

import android.app.Application
import com.github.aliguvenc.coroutinesanddagger.di.DaggerAppComponent

class MyApplication : Application() {

    val appComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }

}