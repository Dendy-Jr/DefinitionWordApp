package com.dendi.android.definitionwordtestapp.data

import com.dendi.android.definitionwordtestapp.core.Abstract

/**
 * @author Dendy-Jr on 28.11.2021
 * olehvynnytskyi@gmail.com
 */
class BaseToDataWordMapper : Abstract.ToDataWordMapper {
    override fun map(
        id: Long,
        word: String,
        phonetic: String,
        phonetics: List<DataPhonetic>,
        origin: String,
        meanings: List<DataMeaning>
    ) = DataWord(
        id = id,
        word = word,
        phonetic = phonetic,
        phonetics = phonetics,
        origin = origin,
        meanings = meanings
    )
}
