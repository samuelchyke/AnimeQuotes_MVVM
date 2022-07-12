package com.itc.anime_quotes.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.itc.anime_quotes.databinding.FragmentAnimeBinding
import com.itc.anime_quotes.databinding.FragmentHomeBinding
import com.itc.anime_quotes.model.AnimeQuotes
import com.itc.anime_quotes.ui.BaseFragment
import com.itc.anime_quotes.util.UIState

class HomeFragment : BaseFragment() {

    private val binding by lazy {

        FragmentHomeBinding.inflate(layoutInflater)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        initRecyclerView()
        observeData()
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

    private fun observeData() {
        animeViewModel.quotes.observe(viewLifecycleOwner) { state ->

            when (state) {

                is UIState.LOADING -> {
                    //Load Spinner
                }

                is UIState.SUCCESS -> {
                    // Update adapter
//                    quoteAdapter.addQuotes(state.response)
                    quoteAdapter.setQuotes(state.response as MutableList<AnimeQuotes>)
                }

                is UIState.ERROR -> {
                    // Show error dialog
                    showError(state.error.localizedMessage) {
                        animeViewModel.getRandomQuotes()
                    }
                }
                else -> {}
            }
        }
        animeViewModel.getRandomQuotes()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}