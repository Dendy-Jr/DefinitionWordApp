package com.dendi.android.definitionwordtestapp.data.cache

import com.dendi.android.definitionwordtestapp.core.Abstract

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
class BaseToCacheWordMapper : Abstract.ToCacheWordMapper<CacheWord.Base> {
    override fun map(
        id: Long,
        word: String,
        phonetic: String,
        origin: String,
        meanings: List<CacheMeaning.Base>
    ) = CacheWord.Base(id, word, phonetic, origin, meanings)
}