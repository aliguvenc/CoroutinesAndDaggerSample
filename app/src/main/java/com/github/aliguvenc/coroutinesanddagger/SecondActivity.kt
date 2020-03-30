package com.github.aliguvenc.coroutinesanddagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class SecondActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.secondActivityComponent().create().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val viewModel = ViewModelProvider(this, viewModelFactory)[SecondViewModel::class.java]
        viewModel.products.observe(this, Observer { })

    }
}
