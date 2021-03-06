package com.dendi.android.definitionwordtestapp.domain

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.presentation.UiDefinition

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
class BaseUiDefinitionMapper : Abstract.DefinitionMapper<UiDefinition> {
    override fun map(
        id: Long,
        antonyms: List<Any>,
        definition: String,
        example: String,
        synonyms: List<String>
    ) = UiDefinition(
        id = id,
        antonyms = antonyms,
        definition = definition,
        example = example,
        synonyms = synonyms
    )
}