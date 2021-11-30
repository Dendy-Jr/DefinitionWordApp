package com.dendi.android.definitionwordtestapp.presentation.fragments

import android.os.Bundle
import android.view.View
import com.dendi.android.definitionwordtestapp.databinding.DefinitionsFragmentBinding
import com.dendi.android.definitionwordtestapp.presentation.UiDefinition
import com.dendi.android.definitionwordtestapp.presentation.adapter.DefinitionAdapter
import com.dendi.android.definitionwordtestapp.presentation.core.BaseFragment

/**
 * @author Dendy-Jr on 30.11.2021
 * olehvynnytskyi@gmail.com
 */
class DefinitionsFragment :
    BaseFragment<DefinitionsFragmentBinding>(DefinitionsFragmentBinding::inflate) {

    override fun setRecyclerView() = viewBinding.rcViewDefinitions
    private val definitionAdapter = DefinitionAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle: Bundle? = this.arguments
        if (arguments != null) {
            val definitions = bundle!!.getParcelableArrayList<UiDefinition.Base>("definitions")
            if (definitions != null) {
                definitionAdapter.map(definitions)
            }
        }
        setAdapter(definitionAdapter)
    }
}