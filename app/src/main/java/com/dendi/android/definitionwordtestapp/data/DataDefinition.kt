package com.dendi.android.definitionwordtestapp.data

import com.dendi.android.definitionwordtestapp.core.Abstract

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
interface DataDefinition {

    fun <T> map(mapper: Abstract.DefinitionMapper<T>): T

    data class Base(
        private val id: Long,
        private val antonyms: List<Any>,
        private val definition: String,
        private val example: String,
        private val synonyms: List<String>
    ) : DataDefinition {
        override fun <T> map(mapper: Abstract.DefinitionMapper<T>): T =
            mapper.map(id, antonyms, definition, example, synonyms)
    }
}