package com.example.roomflowexample.repo.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomflowexample.model.Candle
import com.example.roomflowexample.repo.local.dao.CandleDao

@Database(entities = [Candle::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun candleDao(): CandleDao
}