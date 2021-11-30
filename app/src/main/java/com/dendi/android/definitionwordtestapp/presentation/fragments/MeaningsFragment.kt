package com.dendi.android.definitionwordtestapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dendi.android.definitionwordtestapp.core.ClickListener
import com.dendi.android.definitionwordtestapp.core.navigator
import com.dendi.android.definitionwordtestapp.databinding.MeaningsFragmentBinding
import com.dendi.android.definitionwordtestapp.presentation.UiDefinition
import com.dendi.android.definitionwordtestapp.presentation.UiMeaning
import com.dendi.android.definitionwordtestapp.presentation.adapter.MeaningAdapter

/**
 * @author Dendy-Jr on 30.11.2021
 * olehvynnytskyi@gmail.com
 */
class MeaningsFragment : Fragment() {

    private var _binding: MeaningsFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var meaningAdapter: MeaningAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MeaningsFragmentBinding.inflate(inflater, container, false)

        meaningAdapter = MeaningAdapter(object : ClickListener<List<UiDefinition.Base>> {
            override fun click(item: List<UiDefinition.Base>) {
                val fragment = DefinitionsFragment().apply {
                    arguments = bundleOf("definitions" to item)
                }
                navigator().launchFragment(fragment)
            }
        })


        val bundle: Bundle? = this.arguments
        if (arguments != null) {
            val meaning = bundle!!.getParcelableArrayList<UiMeaning.Base>("meaning")
            if (meaning != null) {
                meaningAdapter.map(meaning)
            }
        }

        setupWordRecyclerView()
        return binding.root
    }

    private fun setupWordRecyclerView() {
        with(binding.rcViewMeanings) {
            adapter = meaningAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}