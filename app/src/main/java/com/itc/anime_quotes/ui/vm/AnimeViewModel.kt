package com.itc.anime_quotes.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.itc.anime_quotes.repository.AnimeRepository
import com.itc.anime_quotes.util.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor (
    private val animeRepository: AnimeRepository
    ) : ViewModel() {

        private val _quotes: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
        val quotes: LiveData<UIState> get() = _quotes

        fun getRandomQuotes() {
            CoroutineScope(Dispatchers.IO).launch {

                try {
                    val response = animeRepository.getRandomQuotes()
                    if (response.isSuccessful) {
                        response.body()?.let {

                            _quotes.postValue(UIState.SUCCESS(it))

                        } ?: throw Exception("Data Null")
                    } else {
                        throw Exception(response.errorBody()?.string())
                    }

                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        _quotes.postValue(UIState.ERROR(e))
                    }
                }
            }
        }

    fun getAnimeQuotes(anime:String) {
        CoroutineScope(Dispatchers.IO).launch {

            try {
                val response = animeRepository.getAnimeQuotes(anime)
                if (response.isSuccessful) {
                    response.body()?.let {

                        _quotes.postValue(UIState.SUCCESS(it))

                    } ?: throw Exception("Data Null")
                } else {
                    throw Exception(response.errorBody()?.string())
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _quotes.postValue(UIState.ERROR(e))
                }
            }
        }
    }

    fun getCharactersQuotes(characters:String) {
        CoroutineScope(Dispatchers.IO).launch {

            try {
                val response = animeRepository.getCharactersQuotes(characters)
                if (response.isSuccessful) {
                    response.body()?.let {

                        _quotes.postValue(UIState.SUCCESS(it))

                    } ?: throw Exception("Data Null")
                } else {
                    throw Exception(response.errorBody()?.string())
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _quotes.postValue(UIState.ERROR(e))
                }
            }
        }
    }

}