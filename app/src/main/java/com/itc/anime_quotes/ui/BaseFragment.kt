package com.itc.anime_quotes.ui

import android.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.itc.anime_quotes.adapter.AnimeQuoteAdapter
import com.itc.anime_quotes.ui.vm.AnimeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseFragment : Fragment() {

    protected  val animeViewModel by lazy{
        ViewModelProvider(requireActivity())[AnimeViewModel::class.java]
    }

    protected val quoteAdapter by lazy{
        AnimeQuoteAdapter()
    }

    protected fun showError(message: String, action: () -> Unit) {
        AlertDialog.Builder(requireContext())
            .setTitle("Error")
            .setMessage(message)
            .setNegativeButton("DISMISS") { dialog, _ ->
                dialog.dismiss()
            }
            .setPositiveButton("RETRY",) { _, _ ->
                action.invoke()
            }

    }

}