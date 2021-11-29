package com.dendi.android.definitionwordtestapp.data

import com.dendi.android.definitionwordtestapp.core.Abstract


/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
interface DataWord {

    fun <T> map(mapper: Abstract.ToDomainWordMapper<T>): T

    data class Base(
        private val id: Long,
        private val word: String,
        private val phonetic: String,
        private val origin: String,
        private val meanings: List<DataMeaning.Base>
    ) : DataWord {
        override fun <T> map(mapper: Abstract.ToDomainWordMapper<T>): T = mapper.map(
            id,
            word,
            phonetic,
            origin,
            meanings.map { it.map(BaseDomainMeaningMapper()) })
    }
}