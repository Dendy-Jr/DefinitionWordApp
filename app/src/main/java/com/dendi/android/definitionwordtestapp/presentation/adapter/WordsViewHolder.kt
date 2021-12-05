package com.dendi.android.definitionwordtestapp.presentation.adapter

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.dendi.android.definitionwordtestapp.R
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.presentation.core.ClickListener
import com.dendi.android.definitionwordtestapp.presentation.UiMeaning
import com.dendi.android.definitionwordtestapp.presentation.UiPhonetic
import com.dendi.android.definitionwordtestapp.presentation.UiWord
import com.dendi.android.definitionwordtestapp.presentation.core.BaseViewHolder
import com.dendi.android.definitionwordtestapp.presentation.fragments.PhoneticsFragment

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
abstract class WordsViewHolder(view: View) : BaseViewHolder<UiWord>(view) {

    class Base(
        view: View,
        private val listenerMeaning: ClickListener<List<UiMeaning>>,
    ) : BaseViewHolder<UiWord>(view) {
        private val wordView = view.findViewById<TextView>(R.id.word)
        private val phoneticView = view.findViewById<TextView>(R.id.phonetic)
        private val originView = view.findViewById<TextView>(R.id.origin)
        private val playPhonetics = view.findViewById<Button>(R.id.play_phonetics)
        private var phoneticList: List<UiPhonetic> = listOf()

        override fun bind(item: UiWord) {
            item.mapper(object : Abstract.UiWordMapper<Unit> {
                override fun map(
                    id: Long,
                    word: String,
                    phonetic: String,
                    phonetics: List<UiPhonetic>,
                    origin: String,
                    meanings: List<UiMeaning>
                ) {
                    wordView.text = word
                    phoneticView.text = phonetic
                    originView.text = origin
                    phoneticList = phonetics
                }

                override fun map(message: String) = Unit
            })

            itemView.setOnClickListener {
                item.mapMeaning(listenerMeaning)
            }

            playPhonetics.setOnClickListener {

                itemView.findNavController().navigate(
                    R.id.action_wordsFragment_to_phoneticsFragment, bundleOf(
                        PhoneticsFragment.KEY_UI_PHONETIC to phoneticList
                    )
                )
            }
        }
    }

    class Fail(view: View) : BaseViewHolder.Fail<UiWord>(view) {
        private val messageView = itemView.findViewById<TextView>(R.id.messageError)
        override fun bind(item: UiWord) {
            item.mapper(object : Abstract.UiWordMapper<Unit> {
                override fun map(
                    id: Long,
                    word: String,
                    phonetic: String,
                    phonetics: List<UiPhonetic>,
                    origin: String,
                    meanings: List<UiMeaning>
                ) = Unit

                override fun map(message: String) {
                    messageView.text = message
                }
            })
        }
    }
}
