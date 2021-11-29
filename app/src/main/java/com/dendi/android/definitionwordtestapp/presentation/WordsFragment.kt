package com.dendi.android.definitionwordtestapp.presentation

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dendi.android.definitionwordtestapp.core.WordApp
import com.dendi.android.definitionwordtestapp.databinding.WordsFragmentBinding
import com.dendi.android.definitionwordtestapp.presentation.adapter.WordAdapter
import javax.inject.Inject

/**
 * @author Dendy-Jr on 28.11.2021
 * olehvynnytskyi@gmail.com
 */
class WordsFragment : Fragment() {

    private var _binding: WordsFragmentBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: WordsViewModelFactory
    private val viewModel: WordsViewModel by viewModels() {
        viewModelFactory
    }
    private val wordAdapter by lazy { WordAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WordsFragmentBinding.inflate(inflater, container, false)

        viewModel.observe(this, {
            it.map(wordAdapter)
        })

        binding.searchBtn.setOnClickListener {
            val text = binding.textInput.text
            viewModel.fetchWordDefinition(text.toString())
            this.hideKeyboard()
            Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
        }
        setupWordRecyclerView()

        return binding.root
    }

    private fun setupWordRecyclerView() {
        with(binding.rcViewWord) {
            adapter = wordAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
