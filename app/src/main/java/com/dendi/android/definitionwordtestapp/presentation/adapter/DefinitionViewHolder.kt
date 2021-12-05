package com.dendi.android.definitionwordtestapp.presentation.adapter

import android.view.View
import android.widget.TextView
import com.dendi.android.definitionwordtestapp.R
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.presentation.UiDefinition
import com.dendi.android.definitionwordtestapp.presentation.core.BaseViewHolder

/**
 * @author Dendy-Jr on 30.11.2021
 * olehvynnytskyi@gmail.com
 */
abstract class DefinitionViewHolder(view: View) : BaseViewHolder<UiDefinition>(view) {

    class Base(view: View) : BaseViewHolder<UiDefinition>(view) {

        private val definitionView = itemView.findViewById<TextView>(R.id.definition)
        private val exampleView = itemView.findViewById<TextView>(R.id.example)
        private val antonymsView = itemView.findViewById<TextView>(R.id.antonyms)
        private val synonymsView = itemView.findViewById<TextView>(R.id.synonyms)

        override fun bind(item: UiDefinition) {
            item.mapper(object : Abstract.DefinitionMapper<Unit> {
                override fun map(
                    id: Long,
                    antonyms: List<Any>,
                    definition: String,
                    example: String,
                    synonyms: List<String>
                ) {
                    definitionView.text = definition
                    exampleView.text = example
                    antonymsView.text = antonyms.toString().replace("[", "").replace("]", "")
                    synonymsView.text = synonyms.toString().replace("[", "").replace("]", "")
                }
            })
        }
    }
}