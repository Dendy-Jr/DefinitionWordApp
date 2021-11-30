package com.dendi.android.definitionwordtestapp.presentation.adapter

import android.view.ViewGroup
import com.dendi.android.definitionwordtestapp.R
import com.dendi.android.definitionwordtestapp.presentation.core.ClickListener
import com.dendi.android.definitionwordtestapp.presentation.UiDefinition
import com.dendi.android.definitionwordtestapp.presentation.UiMeaning
import com.dendi.android.definitionwordtestapp.presentation.core.BaseAdapter
import com.dendi.android.definitionwordtestapp.presentation.core.BaseViewHolder
import com.dendi.android.definitionwordtestapp.presentation.core.DiffUtilCallback

/**
 * @author Dendy-Jr on 30.11.2021
 * olehvynnytskyi@gmail.com
 */
class MeaningAdapter(private val listener: ClickListener<List<UiDefinition.Base>>) :
    BaseAdapter<UiMeaning, BaseViewHolder<UiMeaning>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MeaningViewHolder.Base(R.layout.meaning_item.makeView(parent), listener)

    override fun diffUtilCallback(list: ArrayList<UiMeaning>, data: List<UiMeaning>) =
        MeaningDiffUtilCallback(list, data)

    inner class MeaningDiffUtilCallback(
        oldList: List<UiMeaning>,
        newList: List<UiMeaning>,
    ) : DiffUtilCallback<UiMeaning>(oldList, newList)
}