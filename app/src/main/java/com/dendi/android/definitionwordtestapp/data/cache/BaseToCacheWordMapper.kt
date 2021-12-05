package com.dendi.android.definitionwordtestapp.data.cache

import com.dendi.android.definitionwordtestapp.core.Abstract

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
class BaseToCacheWordMapper : Abstract.ToCacheWordMapper {
    override fun map(
        id: Long,
        word: String,
        phonetic: String,
        phonetics: List<CachePhonetic>,
        origin: String,
        meanings: List<CacheMeaning>
    ) = CacheWord(
        id = id,
        word = word,
        phonetic = phonetic,
        phonetics = phonetics,
        origin = origin,
        meanings = meanings
    )
}