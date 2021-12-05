package com.dendi.android.definitionwordtestapp.data.cloud

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.cache.CachePhonetic

/**
 * @author Dendy-Jr on 04.12.2021
 * olehvynnytskyi@gmail.com
 */
class BaseCachePhoneticMapper : Abstract.PhoneticMapper<CachePhonetic> {
    override fun map(id: Long, audio: String, text: String) =
        CachePhonetic(
            id = id,
            audio = audio,
            text = text
        )
}