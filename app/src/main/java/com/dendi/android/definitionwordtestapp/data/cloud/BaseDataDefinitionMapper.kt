package com.dendi.android.definitionwordtestapp.data.cloud

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.DataDefinition

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
class BaseDataDefinitionMapper : Abstract.DefinitionMapper<DataDefinition.Base> {
    override fun map(
        id: Long,
        antonyms: List<Any>,
        definition: String,
        example: String,
        synonyms: List<String>
    ) = DataDefinition.Base(id, antonyms, definition, example, synonyms)
}