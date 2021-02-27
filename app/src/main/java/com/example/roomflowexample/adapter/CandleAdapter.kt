package com.example.roomflowexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomflowexample.databinding.ItemCandleBinding
import com.example.roomflowexample.model.Candle

class CandleAdapter : RecyclerView.Adapter<CandleAdapter.CandleViewHolder>() {

    private val candleList = mutableListOf<Candle>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemCandleBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    ).let { CandleViewHolder(it) }

    override fun onBindViewHolder(holder: CandleViewHolder, position: Int) {
        holder.loadCandle(candleList[position])
    }

    override fun getItemCount() = candleList.size

    fun loadCandles(candles: List<Candle>) = with(candleList) {
        clear()
        addAll(candles)
        notifyDataSetChanged()
    }

    fun addCandle(candle: Candle) {
        candleList.add(candle)
        notifyItemInserted(candleList.size)
    }

    fun removeCandle(candle: Candle) {
        candleList.remove(candle)
        notifyItemRemoved(candleList.size)
    }

    class CandleViewHolder(private val binding: ItemCandleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun loadCandle(candle: Candle) = with(binding) {
            tvName.text = candle.name
            tvPrice.text = candle.price.toString()
        }
    }
}