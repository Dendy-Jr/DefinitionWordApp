package com.dendi.android.definitionwordtestapp.presentation.adapter

import android.view.View
import android.widget.TextView
import com.dendi.android.definitionwordtestapp.R
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.presentation.UiDefinition
import com.dendi.android.definitionwordtestapp.presentation.UiMeaning
import com.dendi.android.definitionwordtestapp.presentation.core.BaseViewHolder
import com.dendi.android.definitionwordtestapp.presentation.core.ClickListener

/**
 * @author Dendy-Jr on 30.11.2021
 * olehvynnytskyi@gmail.com
 */
abstract class MeaningViewHolder(view: View) : BaseViewHolder<UiMeaning>(view) {

    class Base(view: View, private val listener: ClickListener<List<UiDefinition>>) :
        BaseViewHolder<UiMeaning>(view) {

        private val partOfSpeechView = itemView.findViewById<TextView>(R.id.partOfSpeech)
        override fun bind(item: UiMeaning) {
            item.mapper(object : Abstract.UiMeaningMapper<Unit> {
                override fun map(
                    id: Long,
                    partOfSpeech: String,
                    definitions: List<UiDefinition>
                ) {
                    partOfSpeechView.text = partOfSpeech
                }
            })
            itemView.setOnClickListener {
                item.map(listener)
            }
        }
    }
}