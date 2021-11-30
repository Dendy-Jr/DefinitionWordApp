package com.dendi.android.definitionwordtestapp.presentation.adapter

import android.view.ViewGroup
import com.dendi.android.definitionwordtestapp.R
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.presentation.UiDefinition
import com.dendi.android.definitionwordtestapp.presentation.core.BaseAdapter
import com.dendi.android.definitionwordtestapp.presentation.core.BaseViewHolder
import com.dendi.android.definitionwordtestapp.presentation.core.DiffUtilCallback

/**
 * @author Dendy-Jr on 30.11.2021
 * olehvynnytskyi@gmail.com
 */
class DefinitionAdapter : BaseAdapter<UiDefinition, BaseViewHolder<UiDefinition>>(),
    Abstract.ListMapper<UiDefinition> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DefinitionViewHolder.Base(R.layout.definition_item.makeView(parent))

    override fun diffUtilCallback(list: ArrayList<UiDefinition>, data: List<UiDefinition>) =
        DefinitionDiffUtilCallback(list, data)

    inner class DefinitionDiffUtilCallback(
        oldList: List<UiDefinition>,
        newList: List<UiDefinition>,
    ) : DiffUtilCallback<UiDefinition>(oldList, newList)
}
