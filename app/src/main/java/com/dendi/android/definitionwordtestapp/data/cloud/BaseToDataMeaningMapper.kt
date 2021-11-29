package com.dendi.android.definitionwordtestapp.data.cloud

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.DataDefinition
import com.dendi.android.definitionwordtestapp.data.DataMeaning


/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
class BaseToDataMeaningMapper : Abstract.ToDataMeaningMapper<DataMeaning.Base> {
    override fun map(
        id: Long,
        partOfSpeech: String,
        definitions: List<DataDefinition.Base>
    ) = DataMeaning.Base(id, partOfSpeech, definitions.map { it.map(BaseDataDefinitionMapper()) })
}