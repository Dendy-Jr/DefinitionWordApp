package com.dendi.android.definitionwordtestapp.presentation

import com.dendi.android.definitionwordtestapp.core.Abstract

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
interface UiWord {

    fun <T> map(mapper: Abstract.UiWordMapper<T>): T =
        mapper.map(0, "", "", "", listOf())

    object Progress : UiWord

    data class Base(
        private val id: Long,
        private val word: String,
        private val phonetic: String,
        private val origin: String,
        private val meanings: List<UiMeaning.Base>
    ) : UiWord {
        override fun <T> map(mapper: Abstract.UiWordMapper<T>) = mapper.map(
            id, word, phonetic, origin, meanings
        )
    }

    data class Failure(private val message: String) : UiWord {
        override fun <T> map(mapper: Abstract.UiWordMapper<T>) =
            mapper.map(message)
    }
}