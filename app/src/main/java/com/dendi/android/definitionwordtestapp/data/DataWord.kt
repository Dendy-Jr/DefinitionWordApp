package com.dendi.android.definitionwordtestapp.data

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.domain.DomainWord


/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */

data class DataWord(
    private val id: Long,
    private val word: String,
    private val phonetic: String,
    private val phonetics: List<DataPhonetic>,
    private val origin: String,
    private val meanings: List<DataMeaning>
) : Abstract.Object<DomainWord, Abstract.ToDomainWordMapper> {
    override fun mapper(mapper: Abstract.ToDomainWordMapper) = mapper.map(
        id = id,
        word = word,
        phonetic = phonetic,
        phonetics = phonetics.map { it.mapper(BaseDomainPhoneticMapper()) },
        origin = origin,
        meanings = meanings.map { it.mapper(BaseDomainMeaningMapper()) })
}