package com.dendi.android.definitionwordtestapp.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.dendi.android.definitionwordtestapp.presentation.core.ClickListener
import com.dendi.android.definitionwordtestapp.core.navigator
import com.dendi.android.definitionwordtestapp.databinding.MeaningsFragmentBinding
import com.dendi.android.definitionwordtestapp.presentation.UiDefinition
import com.dendi.android.definitionwordtestapp.presentation.UiMeaning
import com.dendi.android.definitionwordtestapp.presentation.adapter.MeaningAdapter
import com.dendi.android.definitionwordtestapp.presentation.core.BaseFragment

/**
 * @author Dendy-Jr on 30.11.2021
 * olehvynnytskyi@gmail.com
 */
class MeaningsFragment : BaseFragment<MeaningsFragmentBinding>(MeaningsFragmentBinding::inflate) {

    override fun setRecyclerView() = viewBinding.rcViewMeanings
    private lateinit var meaningAdapter: MeaningAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        meaningAdapter = MeaningAdapter(object : ClickListener<List<UiDefinition.Base>> {
            override fun click(item: List<UiDefinition.Base>) {
                val fragment = DefinitionsFragment().apply {
                    arguments = bundleOf("definitions" to item)
                }
                navigator().launchFragment(fragment)
            }
        })
        setAdapter(meaningAdapter)

        val bundle: Bundle? = this.arguments
        if (arguments != null) {
            val meaning = bundle!!.getParcelableArrayList<UiMeaning.Base>("meaning")
            if (meaning != null) {
                meaningAdapter.map(meaning)
            }
        }
    }
}