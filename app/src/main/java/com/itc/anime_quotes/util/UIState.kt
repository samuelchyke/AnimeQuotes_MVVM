package com.itc.anime_quotes.util

import com.itc.anime_quotes.model.AnimeQuotes
import com.itc.anime_quotes.model.AnimeQuotesResponse

sealed class UIState{

    object LOADING: UIState()
    data class SUCCESS(val response: Any): UIState()
    data class ERROR (val error: Exception): UIState()

}

