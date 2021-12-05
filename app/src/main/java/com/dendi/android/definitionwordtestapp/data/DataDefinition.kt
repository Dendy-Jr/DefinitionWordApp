package com.dendi.android.definitionwordtestapp.data

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.domain.DomainDefinition

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */

data class DataDefinition(
    private val id: Long,
    private val antonyms: List<Any>,
    private val definition: String,
    private val example: String,
    private val synonyms: List<String>
) : Abstract.Object<DomainDefinition, Abstract.DefinitionMapper<DomainDefinition>> {
    override fun mapper(mapper: Abstract.DefinitionMapper<DomainDefinition>) =
        mapper.map(
            id = id,
            antonyms = antonyms,
            definition = definition,
            example = example,
            synonyms = synonyms
        )
}