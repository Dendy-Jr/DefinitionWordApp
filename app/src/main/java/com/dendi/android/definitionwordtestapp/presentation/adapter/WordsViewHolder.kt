package com.dendi.android.definitionwordtestapp.presentation.adapter

import android.view.View
import android.widget.TextView
import com.dendi.android.definitionwordtestapp.R
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.presentation.core.ClickListener
import com.dendi.android.definitionwordtestapp.presentation.UiMeaning
import com.dendi.android.definitionwordtestapp.presentation.UiWord
import com.dendi.android.definitionwordtestapp.presentation.core.BaseViewHolder

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
abstract class WordsViewHolder(view: View) : BaseViewHolder<UiWord>(view) {

    class Base(view: View, private val listener: ClickListener<List<UiMeaning.Base>>) :
        BaseViewHolder<UiWord>(view) {
        private val wordView = view.findViewById<TextView>(R.id.word)
        private val phoneticView = view.findViewById<TextView>(R.id.phonetic)
        private val originView = view.findViewById<TextView>(R.id.origin)

        override fun bind(item: UiWord) {
            item.map(object : Abstract.UiWordMapper<Unit> {
                override fun map(
                    id: Long,
                    word: String,
                    phonetic: String,
                    origin: String,
                    meanings: List<UiMeaning.Base>
                ) {
                    wordView.text = word
                    phoneticView.text = phonetic
                    originView.text = origin
                }

                override fun map(message: String) = Unit
            })

            itemView.setOnClickListener {
                item.map(listener)
            }
        }
    }

    class Fail(view: View) : BaseViewHolder.Fail<UiWord>(view) {
        private val messageView = itemView.findViewById<TextView>(R.id.messageError)
        override fun bind(item: UiWord) {
            item.map(object : Abstract.UiWordMapper<Unit> {
                override fun map(
                    id: Long,
                    word: String,
                    phonetic: String,
                    origin: String,
                    meanings: List<UiMeaning.Base>
                ) = Unit

                override fun map(message: String) {
                    messageView.text = message
                }
            })
        }
    }
}
