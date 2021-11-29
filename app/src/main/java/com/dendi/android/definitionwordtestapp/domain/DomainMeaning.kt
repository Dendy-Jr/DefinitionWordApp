package com.dendi.android.definitionwordtestapp.domain

import com.dendi.android.definitionwordtestapp.core.Abstract


/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
interface DomainMeaning {

    fun <T> map(mapper: Abstract.UiMeaningMapper<T>): T

    data class Base(
        private val id: Long,
        private val partOfSpeech: String,
        private val definitions: List<DomainDefinition.Base>
    ) : DomainMeaning {
        override fun <T> map(mapper: Abstract.UiMeaningMapper<T>): T =
            mapper.map(id, partOfSpeech, definitions.map { it.map(BaseUiDefinitionMapper()) })
    }
}