package com.dendi.android.definitionwordtestapp.domain

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.presentation.UiWord


/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */

data class DomainWord(
    private val id: Long,
    private val word: String,
    private val phonetic: String,
    private val phonetics: List<DomainPhonetic>,
    private val origin: String,
    private val meanings: List<DomainMeaning>
) : Abstract.Object<UiWord, Abstract.UiWordMapper<UiWord>> {
    override fun mapper(mapper: Abstract.UiWordMapper<UiWord>) = mapper.map(
        id = id,
        word = word,
        phonetic = phonetic,
        phonetics = phonetics.map { it.mapper(BaseUiPhoneticMapper()) },
        origin = origin,
        meanings = meanings.map { it.mapper(BaseToUiMeaningMapper()) }
    )
}