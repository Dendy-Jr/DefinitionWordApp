package com.dendi.android.definitionwordtestapp.domain

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.presentation.UiDefinition


/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */

data class DomainDefinition(
    private val id: Long,
    private val antonyms: List<Any>,
    private val definition: String,
    private val example: String,
    private val synonyms: List<String>
) : Abstract.Object<UiDefinition, Abstract.DefinitionMapper<UiDefinition>> {
    override fun mapper(mapper: Abstract.DefinitionMapper<UiDefinition>) =
        mapper.map(
            id = id,
            antonyms = antonyms,
            definition = definition,
            example = example,
            synonyms = synonyms
        )
}