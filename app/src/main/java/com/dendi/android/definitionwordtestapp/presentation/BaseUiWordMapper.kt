package com.dendi.android.definitionwordtestapp.presentation

import com.dendi.android.definitionwordtestapp.core.Abstract

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
class BaseUiWordMapper : Abstract.UiWordMapper<UiWord> {
    override fun map(
        id: Long,
        word: String,
        phonetic: String,
        phonetics: List<UiPhonetic>,
        origin: String,
        meanings: List<UiMeaning>
    ) = UiWord.Base(
        id = id,
        word = word,
        phonetic = phonetic,
        phonetics = phonetics,
        origin = origin,
        meanings = meanings
    )

    override fun map(message: String) = UiWord.Failure(message = message)
}