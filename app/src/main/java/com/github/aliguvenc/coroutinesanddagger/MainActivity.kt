package com.github.aliguvenc.coroutinesanddagger

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var myPreferences: MyPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApplication).appComponent.getMainActivityComponent().inject(this)

        val viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.products.observe(this, Observer { })

        textView.setOnClickListener {
            startActivity(
                Intent(this, SecondActivity::class.java)
            )
        }

    }
}
