package com.dendi.android.definitionwordtestapp.data

import com.dendi.android.definitionwordtestapp.core.Abstract

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
sealed class DataWords {

    abstract fun <T> map(mapper: Abstract.WordsDataToDomainMapper<T>): T

    data class Success(
        private val words: List<DataWord>
    ) : DataWords() {
        override fun <T> map(mapper: Abstract.WordsDataToDomainMapper<T>): T =
            mapper.map(words)
    }

    data class Failure(private val message: String) : DataWords() {
        override fun <T> map(mapper: Abstract.WordsDataToDomainMapper<T>): T =
            mapper.map(message)
    }
}