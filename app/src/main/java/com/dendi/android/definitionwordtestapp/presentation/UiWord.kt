package com.dendi.android.definitionwordtestapp.presentation

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.presentation.core.ClickListener

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
sealed class UiWord : Abstract.Object<Unit, Abstract.UiWordMapper<Unit>> {

    override fun mapper(mapper: Abstract.UiWordMapper<Unit>) =
        mapper.map(0, "", "", listOf(), "", listOf())

    open fun mapMeaning(listener: ClickListener<List<UiMeaning>>) = Unit

    open fun mapPhonetic(listener: ClickListener<List<UiPhonetic>>) = Unit

    object Progress : UiWord()

    data class Base(
        private val id: Long,
        private val word: String,
        private val phonetic: String,
        private val phonetics: List<UiPhonetic>,
        private val origin: String,
        private val meanings: List<UiMeaning>
    ) : UiWord() {
        override fun mapper(mapper: Abstract.UiWordMapper<Unit>) = mapper.map(
            id, word, phonetic, phonetics, origin, meanings
        )

        override fun mapMeaning(listener: ClickListener<List<UiMeaning>>) {
            listener.click(meanings)
        }

        override fun mapPhonetic(listener: ClickListener<List<UiPhonetic>>) =
            listener.click(phonetics)
    }

    data class Failure(private val message: String) : UiWord() {
        override fun mapper(mapper: Abstract.UiWordMapper<Unit>) =
            mapper.map(message)
    }
}