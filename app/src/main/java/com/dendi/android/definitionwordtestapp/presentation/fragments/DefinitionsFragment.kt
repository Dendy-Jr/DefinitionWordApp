package com.dendi.android.definitionwordtestapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dendi.android.definitionwordtestapp.databinding.DefinitionsFragmentBinding
import com.dendi.android.definitionwordtestapp.presentation.UiDefinition
import com.dendi.android.definitionwordtestapp.presentation.adapter.DefinitionAdapter

/**
 * @author Dendy-Jr on 30.11.2021
 * olehvynnytskyi@gmail.com
 */
class DefinitionsFragment : Fragment() {

    private var _binding: DefinitionsFragmentBinding? = null
    private val binding get() = _binding!!

    private val definitionAdapter = DefinitionAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DefinitionsFragmentBinding.inflate(inflater, container, false)

        val bundle: Bundle? = this.arguments
        if (arguments != null) {
            val definitions = bundle!!.getParcelableArrayList<UiDefinition.Base>("definitions")
            if (definitions != null) {
                definitionAdapter.map(definitions)
            }
        }

        setupWordRecyclerView()
        return binding.root
    }

    private fun setupWordRecyclerView() {
        with(binding.rcViewDefinitions) {
            adapter = definitionAdapter
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