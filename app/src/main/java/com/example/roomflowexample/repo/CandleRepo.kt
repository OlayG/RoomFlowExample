package com.example.roomflowexample.repo

import com.example.roomflowexample.model.Candle
import com.example.roomflowexample.repo.local.dao.CandleDao
import javax.inject.Inject

class CandleRepo @Inject constructor(private val candleDao: CandleDao) {

    val candles = candleDao.getAll()

    suspend fun insertCandle(candle: Candle) = candleDao.insertAll(candle)

    suspend fun deleteCandle(candle: Candle) = candleDao.delete(candle)
}