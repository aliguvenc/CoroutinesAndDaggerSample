package com.github.aliguvenc.coroutinesanddagger

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.aliguvenc.coroutinesanddagger.adapter.PhotoRecyclerViewAdapter
import com.github.aliguvenc.coroutinesanddagger.databinding.ActivityMainBinding
import com.github.aliguvenc.coroutinesanddagger.extensions.openActivity
import com.github.aliguvenc.coroutinesanddagger.listeners.SelectionListener
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val mainViewModel by viewModels<MainViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {

        val mainActivityComponent =
            (application as MyApplication).appComponent.mainActivityComponent().create()
        mainActivityComponent.inject(this)

        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
                .apply {
                    viewModel = mainViewModel
                    lifecycleOwner = this@MainActivity
                }

        binding.photoList.run {
            setHasFixedSize(true)
            adapter = PhotoRecyclerViewAdapter(SelectionListener {
                openActivity<SecondActivity>()
            })
        }
    }
}
