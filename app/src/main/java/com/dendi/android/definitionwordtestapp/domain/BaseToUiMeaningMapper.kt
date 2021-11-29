package com.dendi.android.definitionwordtestapp.domain

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.presentation.UiDefinition
import com.dendi.android.definitionwordtestapp.presentation.UiMeaning

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
class BaseToUiMeaningMapper : Abstract.UiMeaningMapper<UiMeaning.Base> {
    override fun map(
        id: Long,
        partOfSpeech: String,
        definitions: List<UiDefinition.Base>
    ) = UiMeaning.Base(id, partOfSpeech, definitions)
}