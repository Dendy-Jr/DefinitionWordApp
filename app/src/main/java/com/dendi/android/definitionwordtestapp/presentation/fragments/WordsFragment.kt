package com.dendi.android.definitionwordtestapp.presentation.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dendi.android.definitionwordtestapp.presentation.core.ClickListener
import com.dendi.android.definitionwordtestapp.core.WordApp
import com.dendi.android.definitionwordtestapp.core.navigator
import com.dendi.android.definitionwordtestapp.databinding.WordsFragmentBinding
import com.dendi.android.definitionwordtestapp.presentation.UiMeaning
import com.dendi.android.definitionwordtestapp.presentation.WordsViewModel
import com.dendi.android.definitionwordtestapp.presentation.WordsViewModelFactory
import com.dendi.android.definitionwordtestapp.presentation.adapter.WordsAdapter
import com.dendi.android.definitionwordtestapp.presentation.core.BaseFragment
import javax.inject.Inject

/**
 * @author Dendy-Jr on 28.11.2021
 * olehvynnytskyi@gmail.com
 */
class WordsFragment : BaseFragment<WordsFragmentBinding>(WordsFragmentBinding::inflate) {

    override fun setRecyclerView() = viewBinding.rcViewWord

    @Inject
    lateinit var viewModelFactory: WordsViewModelFactory
    private val viewModel: WordsViewModel by viewModels() {
        viewModelFactory
    }
    private lateinit var wordAdapter: WordsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wordAdapter = WordsAdapter(object : ClickListener<List<UiMeaning.Base>> {
            override fun click(item: List<UiMeaning.Base>) {
                val fragment = MeaningsFragment().apply {
                    arguments = bundleOf("meaning" to item)
                }
                navigator().launchFragment(fragment)
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

    private fun inject() {
        val application = requireActivity().application as WordApp
        val appComponent = application.component
        appComponent.inject(this)
    }
}
