package com.dendi.android.definitionwordtestapp.data.cloud

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.BaseDomainDefinitionMapper
import com.dendi.android.definitionwordtestapp.data.DataDefinition
import com.dendi.android.definitionwordtestapp.data.DataMeaning


/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
class BaseToDataMeaningMapper : Abstract.ToDataMeaningMapper {
    override fun map(
        id: Long,
        partOfSpeech: String,
        definitions: List<DataDefinition>
    ) = DataMeaning(
        id = id,
        partOfSpeech = partOfSpeech,
        definitions = definitions)
}