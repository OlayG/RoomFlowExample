package com.example.roomflowexample.module

import android.content.Context
import androidx.room.Room
import com.example.roomflowexample.repo.local.AppDatabase
import com.example.roomflowexample.repo.local.dao.CandleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CandleDbModule {

    @Provides
    @Singleton
    fun providesDb(
        @ApplicationContext appContext: Context
    ): AppDatabase = Room.databaseBuilder(
        appContext,
        AppDatabase::class.java, "database-name"
    ).build()

    @Provides
    @Singleton
    fun providesCandleDao(db: AppDatabase): CandleDao = db.candleDao()
}
