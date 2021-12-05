package com.dendi.android.definitionwordtestapp.data

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.domain.DomainWords

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
sealed class DataWords : Abstract.Object<DomainWords, Abstract.WordsDataToDomainMapper> {

    data class Success(
        private val words: List<DataWord>
    ) : DataWords() {
        override fun mapper(mapper: Abstract.WordsDataToDomainMapper) =
            mapper.map(words)
    }

    data class Failure(private val message: String) : DataWords() {
        override fun mapper(mapper: Abstract.WordsDataToDomainMapper) =
            mapper.map(message)
    }
}