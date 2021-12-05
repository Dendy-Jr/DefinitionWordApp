package com.dendi.android.definitionwordtestapp.data

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.domain.DomainMeaning

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */

data class DataMeaning(
    private val id: Long,
    private val partOfSpeech: String,
    private val definitions: List<DataDefinition>
) : Abstract.Object<DomainMeaning, Abstract.ToDomainMeaningMapper> {
    override fun mapper(mapper: Abstract.ToDomainMeaningMapper) =
        mapper.map(
            id = id,
            partOfSpeech = partOfSpeech,
            definitions = definitions.map { it.mapper(mapper = BaseDomainDefinitionMapper()) }
        )
}