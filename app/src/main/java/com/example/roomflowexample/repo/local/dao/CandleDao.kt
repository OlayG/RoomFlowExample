package com.example.roomflowexample.repo.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.roomflowexample.model.Candle
import kotlinx.coroutines.flow.Flow

@Dao
interface CandleDao {
    @Query("SELECT * FROM candle")
    fun getAll(): Flow<List<Candle>>

    @Insert
    suspend fun insertAll(vararg candles: Candle)

    @Delete
    suspend fun delete(candle: Candle)
}