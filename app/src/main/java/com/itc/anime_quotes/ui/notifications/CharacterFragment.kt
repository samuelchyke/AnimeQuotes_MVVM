package com.itc.anime_quotes.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.itc.anime_quotes.databinding.FragmentCharactersBinding
import com.itc.anime_quotes.model.AnimeQuotes
import com.itc.anime_quotes.ui.BaseFragment
import com.itc.anime_quotes.util.UIState

class CharacterFragment : BaseFragment() {

    private val binding by lazy{
        FragmentCharactersBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        initRecyclerView()

        binding.button.setOnClickListener {
            val character = binding.characterEditTxt.text.toString()
            observeData(character)
        }
        return binding.root
    }

    private fun initRecyclerView() {
        //Recycler View
        binding.animeRecVw.apply {
            this.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = quoteAdapter
        }
    }

    private fun observeData(character: String) {
        animeViewModel.quotes.observe(viewLifecycleOwner) { state ->

            when (state) {

                is UIState.LOADING -> {
                    //Load Spinner
                }

                is UIState.SUCCESS -> {
                    // Update adapter
                    quoteAdapter.setQuotes(state.response as MutableList<AnimeQuotes>)
                }

                is UIState.ERROR -> {
                    // Show error dialog
                    showError(state.error.localizedMessage) {
                        animeViewModel.getCharactersQuotes(character)
                    }
                }
                else -> {}
            }
        }
        animeViewModel.getCharactersQuotes(character)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}