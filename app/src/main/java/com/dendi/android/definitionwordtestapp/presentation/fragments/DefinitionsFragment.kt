package com.dendi.android.definitionwordtestapp.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.dendi.android.definitionwordtestapp.databinding.DefinitionsFragmentBinding
import com.dendi.android.definitionwordtestapp.presentation.adapter.DefinitionAdapter
import com.dendi.android.definitionwordtestapp.presentation.core.BaseFragment

/**
 * @author Dendy-Jr on 30.11.2021
 * olehvynnytskyi@gmail.com
 */
class DefinitionsFragment :
    BaseFragment<DefinitionsFragmentBinding>(DefinitionsFragmentBinding::inflate) {

    private val args: DefinitionsFragmentArgs by navArgs()

    override fun setRecyclerView() = viewBinding.rcViewDefinitions
    private val definitionAdapter = DefinitionAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter(definitionAdapter)
        definitionAdapter.map(args.definitions.toList())
    }
}