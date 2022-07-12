package com.itc.anime_quotes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itc.anime_quotes.databinding.QuotesRowViewBinding
import com.itc.anime_quotes.model.AnimeQuotes

class AnimeQuoteAdapter(
    private val mAnimeQuotesList: MutableList<AnimeQuotes> = mutableListOf()
) : RecyclerView.Adapter<MyViewHolder>(
) {

    fun addQuotes(quotes: AnimeQuotes){
        mAnimeQuotesList.addAll(listOf(quotes))
    }

    fun setQuotes(quotes: MutableList<AnimeQuotes>) {
        mAnimeQuotesList.clear()
        mAnimeQuotesList.addAll(quotes)
        notifyDataSetChanged()
    }

    fun setQuotes() {
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MyViewHolder =
        MyViewHolder(
            QuotesRowViewBinding.inflate(
                LayoutInflater.from(parent.context ),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) =
        holder.bind(mAnimeQuotesList[position])

    override fun getItemCount(): Int  = mAnimeQuotesList.size

}

class MyViewHolder(
    private val binding: QuotesRowViewBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind(quotes: AnimeQuotes)
    {
        binding.animeTxtVw.text = quotes.anime
        binding.characterTxtVw.text = quotes.character
        binding.quotesTxtVw.text = quotes.quote
    }

}