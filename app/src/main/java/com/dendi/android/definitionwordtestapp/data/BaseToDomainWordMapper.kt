package com.dendi.android.definitionwordtestapp.data

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.domain.DomainMeaning
import com.dendi.android.definitionwordtestapp.domain.DomainPhonetic
import com.dendi.android.definitionwordtestapp.domain.DomainWord

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
class BaseToDomainWordMapper : Abstract.ToDomainWordMapper {
    override fun map(
        id: Long,
        word: String,
        phonetic: String,
        phonetics: List<DomainPhonetic>,
        origin: String,
        meanings: List<DomainMeaning>
    ) = DomainWord(
        id = id,
        word = word,
        phonetic = phonetic,
        phonetics = phonetics,
        origin = origin,
        meanings = meanings
    )
}