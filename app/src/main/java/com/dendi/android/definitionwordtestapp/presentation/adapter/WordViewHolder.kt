package com.dendi.android.definitionwordtestapp.presentation.adapter

import android.text.TextUtils
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dendi.android.definitionwordtestapp.R
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.presentation.UiDefinition
import com.dendi.android.definitionwordtestapp.presentation.UiMeaning
import com.dendi.android.definitionwordtestapp.presentation.UiWord

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
abstract class WordViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    open fun bind(word: UiWord) {}

    class FullscreenProgress(view: View) : WordViewHolder(view)

    class Base(view: View) : WordViewHolder(view) {
        private val wordView = view.findViewById<TextView>(R.id.word)
        private val phoneticView = view.findViewById<TextView>(R.id.phonetic)
        private val originView = view.findViewById<TextView>(R.id.origin)
        private val partOfSpeechView = view.findViewById<TextView>(R.id.partOfSpeech)
        private val definitionView = view.findViewById<TextView>(R.id.definition)
        private val exampleView = view.findViewById<TextView>(R.id.example)
        private val antonymsView = view.findViewById<TextView>(R.id.antonyms)
        private val synonymsView = view.findViewById<TextView>(R.id.synonyms)

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


                    meanings.map {
                        it.map(object : Abstract.UiMeaningMapper<Unit> {
                            override fun map(
                                id: Long,
                                partOfSpeech: String,
                                definitions: List<UiDefinition.Base>
                            ) {
                                partOfSpeechView.text = partOfSpeech
                                definitions.map {
                                    it.map(object : Abstract.DefinitionMapper<Unit> {
                                        override fun map(
                                            id: Long,
                                            antonyms: List<Any>,
                                            definition: String,
                                            example: String,
                                            synonyms: List<String>
                                        ) {
                                            definitionView.text = definition
                                            exampleView.text = example
                                            antonymsView.text = TextUtils.join(",", antonyms)
                                            synonymsView.text = TextUtils.join(",", synonyms)
                                        }
                                    })
                                }
                            }
                        })
                    }
                }

                override fun map(message: String) = Unit
            })
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
