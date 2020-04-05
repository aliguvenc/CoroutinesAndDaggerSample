package com.github.aliguvenc.coroutinesanddagger

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

const val USER_NAME = "user_name"

class MyPreferences @Inject constructor(private val context: Context) {

    private val preferences: SharedPreferences by lazy {
        context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
    }

    var userName: String?
        get() {
            return preferences[USER_NAME]
        }
        set(value) {
            preferences[USER_NAME] = value
        }
}