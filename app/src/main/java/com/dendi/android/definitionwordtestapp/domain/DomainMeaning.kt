package com.dendi.android.definitionwordtestapp.domain

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.presentation.UiMeaning


/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */

data class DomainMeaning(
    private val id: Long,
    private val partOfSpeech: String,
    private val definitions: List<DomainDefinition>
) : Abstract.Object<UiMeaning, Abstract.UiMeaningMapper<UiMeaning>> {
    override fun mapper(mapper: Abstract.UiMeaningMapper<UiMeaning>) =
        mapper.map(
            id = id,
            partOfSpeech = partOfSpeech,
            definitions = definitions.map { it.mapper(BaseUiDefinitionMapper()) })
}