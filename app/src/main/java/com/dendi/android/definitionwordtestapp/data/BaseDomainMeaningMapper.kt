package com.dendi.android.definitionwordtestapp.data

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.domain.DomainDefinition
import com.dendi.android.definitionwordtestapp.domain.DomainMeaning

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
class BaseDomainMeaningMapper : Abstract.ToDomainMeaningMapper {
    override fun map(
        id: Long,
        partOfSpeech: String,
        definitions: List<DomainDefinition>
    ) = DomainMeaning(
        id = id,
        partOfSpeech = partOfSpeech,
        definitions = definitions
    )
}