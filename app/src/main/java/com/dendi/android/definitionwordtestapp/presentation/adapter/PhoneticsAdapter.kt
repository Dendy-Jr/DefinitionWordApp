package com.dendi.android.definitionwordtestapp.presentation.adapter

import android.view.ViewGroup
import com.dendi.android.definitionwordtestapp.R
import com.dendi.android.definitionwordtestapp.presentation.UiPhonetic
import com.dendi.android.definitionwordtestapp.presentation.core.BaseAdapter
import com.dendi.android.definitionwordtestapp.presentation.core.BaseViewHolder
import com.dendi.android.definitionwordtestapp.presentation.core.DiffUtilCallback

/**
 * @author Dendy-Jr on 04.12.2021
 * olehvynnytskyi@gmail.com
 */
class PhoneticsAdapter : BaseAdapter<UiPhonetic, BaseViewHolder<UiPhonetic>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PhoneticsViewHolder.Base(R.layout.phonetic_item.makeView(parent))

    override fun diffUtilCallback(
        list: ArrayList<UiPhonetic>,
        data: List<UiPhonetic>
    ) = DefinitionDiffUtilCallback(list, data)

    inner class DefinitionDiffUtilCallback(
        oldList: List<UiPhonetic>,
        newList: List<UiPhonetic>,
    ) : DiffUtilCallback<UiPhonetic>(oldList, newList)
}