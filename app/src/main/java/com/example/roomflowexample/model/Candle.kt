package com.example.roomflowexample.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Candle(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    val name: String,
    val price: Int
) : Parcelable