package com.dendi.android.definitionwordtestapp.data

import com.dendi.android.definitionwordtestapp.core.Abstract

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
interface DataMeaning {

    fun <T> map(mapper: Abstract.ToDomainMeaningMapper<T>): T

    data class Base(
        private val id: Long,
        private val partOfSpeech: String,
        private val definitions: List<DataDefinition.Base>
    ) : DataMeaning {
        override fun <T> map(mapper: Abstract.ToDomainMeaningMapper<T>): T =
            mapper.map(id, partOfSpeech, definitions.map { it.map(BaseDomainDefinitionMapper()) })
    }
}