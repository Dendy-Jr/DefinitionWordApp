package com.dendi.android.definitionwordtestapp.domain

import com.dendi.android.definitionwordtestapp.core.Abstract


/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
interface DomainDefinition {

    fun <T> map(mapper: Abstract.DefinitionMapper<T>): T

    data class Base(
        private val id: Long,
        private val antonyms: List<Any>,
        private val definition: String,
        private val example: String,
        private val synonyms: List<String>
    ) : DomainDefinition {
        override fun <T> map(mapper: Abstract.DefinitionMapper<T>): T =
            mapper.map(id, antonyms, definition, example, synonyms)
    }
}