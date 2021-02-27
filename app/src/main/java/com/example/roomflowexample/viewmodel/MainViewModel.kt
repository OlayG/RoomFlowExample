package com.example.roomflowexample.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.roomflowexample.model.Candle
import com.example.roomflowexample.repo.CandleRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val candleRepo: CandleRepo
    ) : ViewModel() {
    companion object {
        private const val TAG = "MainViewModel"
    }

    val candles = candleRepo.candles.asLiveData(viewModelScope.coroutineContext)

    fun addCandle() {
        val candle = Candle(name = "Name${Random().nextInt()}", price = Random().nextInt())
        Log.d(TAG, "addCandle: $candle")
        viewModelScope.launch {
            candleRepo.insertCandle(candle)
        }
    }

    fun removeCandle(candle: Candle) {
        viewModelScope.launch(Dispatchers.IO) {
            candleRepo.deleteCandle(candle)
        }
    }

}