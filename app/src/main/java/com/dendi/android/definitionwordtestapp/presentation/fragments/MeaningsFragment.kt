package com.dendi.android.definitionwordtestapp.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.dendi.android.definitionwordtestapp.presentation.core.ClickListener
import com.dendi.android.definitionwordtestapp.databinding.MeaningsFragmentBinding
import com.dendi.android.definitionwordtestapp.presentation.UiDefinition
import com.dendi.android.definitionwordtestapp.presentation.adapter.MeaningAdapter
import com.dendi.android.definitionwordtestapp.presentation.core.BaseFragment

/**
 * @author Dendy-Jr on 30.11.2021
 * olehvynnytskyi@gmail.com
 */
class MeaningsFragment : BaseFragment<MeaningsFragmentBinding>(MeaningsFragmentBinding::inflate) {

    private val args: MeaningsFragmentArgs by navArgs()

    override fun setRecyclerView() = viewBinding.rcViewMeanings
    private lateinit var meaningAdapter: MeaningAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        meaningAdapter = MeaningAdapter(object : ClickListener<List<UiDefinition>> {
            override fun click(item: List<UiDefinition>) {
                val directions =
                    MeaningsFragmentDirections.actionMeaningsFragmentToDefinitionsFragment(item.toTypedArray())
                findNavController().navigate(directions)
            }
        })
        setAdapter(meaningAdapter)
        meaningAdapter.map(args.meanings.toList())
    }
}
