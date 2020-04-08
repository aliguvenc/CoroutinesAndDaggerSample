package com.github.aliguvenc.coroutinesanddagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class SecondActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val seconViewModel by viewModels<SecondViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.secondActivityComponent().create().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        seconViewModel.products.observe(this, Observer { })
    }
}
