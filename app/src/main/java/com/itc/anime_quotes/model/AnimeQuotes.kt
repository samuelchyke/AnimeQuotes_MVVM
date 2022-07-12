package com.itc.anime_quotes.model


import com.google.gson.annotations.SerializedName

data class AnimeQuotes(
    @SerializedName("anime")
    val anime: String?,
    @SerializedName("character")
    val character: String?,
    @SerializedName("quote")
    val quote: String?
)