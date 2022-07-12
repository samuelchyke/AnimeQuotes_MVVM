package com.itc.anime_quotes.repository

import com.itc.anime_quotes.api.AnimeServiceApi
import com.itc.anime_quotes.model.AnimeQuotes
import com.itc.anime_quotes.model.AnimeQuotesResponse
import retrofit2.Response
import javax.inject.Inject

interface AnimeRepository {
   suspend fun getRandomQuotes(): Response<AnimeQuotesResponse>
   suspend fun getAnimeQuotes(anime: String): Response<AnimeQuotesResponse>
   suspend fun getCharactersQuotes(character: String): Response<AnimeQuotesResponse>
}

class AnimeRepositoryImpl @Inject constructor (
   private val animeServiceApi: AnimeServiceApi
        ) : AnimeRepository{

    override suspend fun getRandomQuotes(): Response<AnimeQuotesResponse> {
        return animeServiceApi.getRandomQuotes()
    }

    override suspend fun getAnimeQuotes(anime: String): Response<AnimeQuotesResponse> {
        return animeServiceApi.getAnimeQuotes(anime)
    }

    override suspend fun getCharactersQuotes(character: String): Response<AnimeQuotesResponse> {
        return animeServiceApi.getCharacterQuotes(character)
    }

}
