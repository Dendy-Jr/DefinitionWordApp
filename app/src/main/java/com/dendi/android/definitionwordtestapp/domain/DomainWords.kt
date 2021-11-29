package com.dendi.android.definitionwordtestapp.domain

import com.dendi.android.definitionwordtestapp.core.Abstract

/**
 * @author Dendy-Jr on 28.11.2021
 * olehvynnytskyi@gmail.com
 */
sealed class DomainWords {

    abstract fun <T> map(mapper: Abstract.WordsDomainToUiMapper<T>): T

    data class Success(private val words: List<DomainWord>) : DomainWords() {
        override fun <T> map(mapper: Abstract.WordsDomainToUiMapper<T>): T =
            mapper.map(words)
    }

    data class Failure(private val message: String) : DomainWords() {
        override fun <T> map(mapper: Abstract.WordsDomainToUiMapper<T>): T =
            mapper.map(message)
    }
}