package com.dendi.android.definitionwordtestapp.domain

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.presentation.UiWords

/**
 * @author Dendy-Jr on 28.11.2021
 * olehvynnytskyi@gmail.com
 */
sealed class DomainWords : Abstract.Object<UiWords, Abstract.WordsDomainToUiMapper> {

    data class Success(private val words: List<DomainWord>) : DomainWords() {
        override fun mapper(mapper: Abstract.WordsDomainToUiMapper) =
            mapper.map(words)
    }

    data class Failure(private val message: String) : DomainWords() {
        override fun mapper(mapper: Abstract.WordsDomainToUiMapper) =
            mapper.map(message)
    }
}