package com.itc.anime_quotes.api

import com.itc.anime_quotes.model.AnimeQuotes
import com.itc.anime_quotes.model.AnimeQuotesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeServiceApi {

    @GET(QUOTES_PATH)
    suspend fun getRandomQuotes():Response<AnimeQuotesResponse>

    @GET(ANIME_PATH)
    suspend fun getAnimeQuotes(
        @Query("title") title: String
    ):Response<AnimeQuotesResponse>

    @GET(CHARACTER_PATH)
    suspend fun getCharacterQuotes(
        @Query("name") character: String
    ):Response<AnimeQuotesResponse>

    companion object{

        const val BASE_URL = "https://animechan.vercel.app/api/"
        private const val QUOTES_PATH = "quotes"
        private const val ANIME_PATH = "quotes/anime/"
        private const val CHARACTER_PATH = "quotes/character"

    }

}
