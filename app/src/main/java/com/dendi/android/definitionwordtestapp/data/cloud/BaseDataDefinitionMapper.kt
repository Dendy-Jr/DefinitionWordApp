package com.dendi.android.definitionwordtestapp.data.cloud

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.DataDefinition

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
class BaseDataDefinitionMapper : Abstract.DefinitionMapper<DataDefinition> {
    override fun map(
        id: Long,
        antonyms: List<Any>,
        definition: String,
        example: String,
        synonyms: List<String>
    ) = DataDefinition(
        id = id,
        antonyms = antonyms,
        definition = definition,
        example = example,
        synonyms = synonyms
    )
}