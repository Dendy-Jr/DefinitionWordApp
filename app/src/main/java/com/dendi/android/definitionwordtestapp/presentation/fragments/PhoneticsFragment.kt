package com.dendi.android.definitionwordtestapp.presentation.fragments

import android.os.Bundle
import android.view.View
import com.dendi.android.definitionwordtestapp.databinding.PhoneticsFragmentBinding
import com.dendi.android.definitionwordtestapp.presentation.UiPhonetic
import com.dendi.android.definitionwordtestapp.presentation.adapter.PhoneticsAdapter
import com.dendi.android.definitionwordtestapp.presentation.core.BaseFragment

/**
 * @author Dendy-Jr on 04.12.2021
 * olehvynnytskyi@gmail.com
 */
class PhoneticsFragment :
    BaseFragment<PhoneticsFragmentBinding>(PhoneticsFragmentBinding::inflate) {

    override fun setRecyclerView() = viewBinding.rcViewPhonetics
    private val phoneticAdapter = PhoneticsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = requireArguments().getParcelableArrayList<UiPhonetic>(KEY_UI_PHONETIC)
        if (bundle != null) {
            phoneticAdapter.map(bundle)
        }
        setAdapter(phoneticAdapter)
    }

    companion object {
        const val KEY_UI_PHONETIC = "KEY_UI_PHONETIC"
    }
}