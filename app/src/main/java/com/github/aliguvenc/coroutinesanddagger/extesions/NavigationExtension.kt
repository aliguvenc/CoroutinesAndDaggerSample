package com.github.aliguvenc.coroutinesanddagger.extesions

import android.app.Activity
import android.content.Intent

inline fun <reified T : Activity> Activity.openActivity() {
    startActivity(Intent(this, T::class.java))
}