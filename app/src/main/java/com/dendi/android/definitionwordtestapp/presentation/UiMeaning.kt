package com.dendi.android.definitionwordtestapp.presentation

import com.dendi.android.definitionwordtestapp.core.Abstract


/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
interface UiMeaning {

    fun <T> map(mapper: Abstract.UiMeaningMapper<T>): T

    data class Base(
        private val id: Long,
        private val partOfSpeech: String,
        private val definitions: List<UiDefinition.Base>
    ) : UiMeaning {
        override fun <T> map(mapper: Abstract.UiMeaningMapper<T>): T =
            mapper.map(id, partOfSpeech, definitions)
    }
}