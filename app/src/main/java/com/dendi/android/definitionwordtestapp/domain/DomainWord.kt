package com.dendi.android.definitionwordtestapp.domain

import com.dendi.android.definitionwordtestapp.core.Abstract


/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
interface DomainWord {

    fun <T> map(mapper: Abstract.UiWordMapper<T>): T

    data class Base(
        private val id: Long,
        private val word: String,
        private val phonetic: String,
        private val origin: String,
        private val meanings: List<DomainMeaning.Base>
    ) : DomainWord {
        override fun <T> map(mapper: Abstract.UiWordMapper<T>): T = mapper.map(
            id,
            word,
            phonetic,
            origin,
            meanings.map { it.map(BaseToUiMeaningMapper()) }
        )
    }
}