package com.example.roomflowexample.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomflowexample.adapter.CandleAdapter
import com.example.roomflowexample.databinding.ActivityMainBinding
import com.example.roomflowexample.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val candleAdapter by lazy { CandleAdapter() }
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupCandleRv()
        setButtonListeners()
        setObservers()
    }

    private fun setupCandleRv() = with(binding.rvCandles) {
        layoutManager = LinearLayoutManager(context)
        adapter = candleAdapter
    }

    private fun setButtonListeners() = with(binding) {
        btnAdd.setOnClickListener { mainViewModel.addCandle() }
        btnRemove.setOnClickListener {

        }
    }

    private fun setObservers() {
        mainViewModel.candles.observe(this) {
            Log.d(TAG, "setObservers: $it")
            candleAdapter.loadCandles(it)
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}