package com.dendi.android.definitionwordtestapp.presentation.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dendi.android.definitionwordtestapp.presentation.core.ClickListener
import com.dendi.android.definitionwordtestapp.databinding.WordsFragmentBinding
import com.dendi.android.definitionwordtestapp.presentation.UiMeaning
import com.dendi.android.definitionwordtestapp.presentation.WordsViewModel
import com.dendi.android.definitionwordtestapp.presentation.adapter.WordsAdapter
import com.dendi.android.definitionwordtestapp.presentation.core.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author Dendy-Jr on 28.11.2021
 * olehvynnytskyi@gmail.com
 */
class WordsFragment : BaseFragment<WordsFragmentBinding>(WordsFragmentBinding::inflate) {

    override fun setRecyclerView() = viewBinding.rcViewWord

    private val viewModel by viewModel<WordsViewModel>()
    private lateinit var wordAdapter: WordsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wordAdapter = WordsAdapter(object : ClickListener<List<UiMeaning>> {
            override fun click(item: List<UiMeaning>) {
                val directions =
                    WordsFragmentDirections.actionWordsFragmentToMeaningsFragment(item.toTypedArray())
                findNavController().navigate(directions)
            }
        })

        setAdapter(wordAdapter)

        viewModel.observe(this, {
            it.map(wordAdapter)
        })

        viewBinding.searchBtn.setOnClickListener {
            val text = viewBinding.textInput.text
            viewModel.fetchWordDefinition(text.toString())
            this.hideKeyboard()
        }
    }

    private fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
