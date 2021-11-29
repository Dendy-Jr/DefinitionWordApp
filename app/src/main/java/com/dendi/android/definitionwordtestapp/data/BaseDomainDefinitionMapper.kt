package com.dendi.android.definitionwordtestapp.data

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.domain.DomainDefinition

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
class BaseDomainDefinitionMapper : Abstract.DefinitionMapper<DomainDefinition.Base> {
    override fun map(
        id: Long,
        antonyms: List<Any>,
        definition: String,
        example: String,
        synonyms: List<String>
    ) = DomainDefinition.Base(id, antonyms, definition, example, synonyms)
}
