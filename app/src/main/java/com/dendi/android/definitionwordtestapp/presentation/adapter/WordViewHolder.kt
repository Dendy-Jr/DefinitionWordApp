package com.dendi.android.definitionwordtestapp.presentation.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dendi.android.definitionwordtestapp.R
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.core.ClickListener
import com.dendi.android.definitionwordtestapp.presentation.UiMeaning
import com.dendi.android.definitionwordtestapp.presentation.UiWord

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
abstract class WordViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    open fun bind(word: UiWord) {}

    class FullscreenProgress(view: View) : WordViewHolder(view)

    class Base(view: View, private val listener: ClickListener<List<UiMeaning.Base>>) :
        WordViewHolder(view) {
        private val wordView = view.findViewById<TextView>(R.id.word)
        private val phoneticView = view.findViewById<TextView>(R.id.phonetic)
        private val originView = view.findViewById<TextView>(R.id.origin)

        override fun bind(word: UiWord) {
            word.map(object : Abstract.UiWordMapper<Unit> {
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
                word.map(listener)
            }
        }
    }

    class Fail(view: View) : WordViewHolder(view) {
        private val messageView = itemView.findViewById<TextView>(R.id.messageError)
        override fun bind(word: UiWord) {
            word.map(object : Abstract.UiWordMapper<Unit> {
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
