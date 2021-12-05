package com.dendi.android.definitionwordtestapp.data.cloud

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.cache.CachePhonetic
import com.google.gson.annotations.SerializedName

/**
 * @author Dendy-Jr on 04.12.2021
 * olehvynnytskyi@gmail.com
 */

data class CloudPhonetic(
    @SerializedName("text")
    private val text: String? = "",
    @SerializedName("audio")
    private val audio: String? = ""
) : Abstract.Object<CachePhonetic, Abstract.PhoneticMapper<CachePhonetic>> {
    override fun mapper(mapper: Abstract.PhoneticMapper<CachePhonetic>) =
        mapper.map(
            id = 0,
            audio = audio ?: "",
            text = text ?: ""
        )
}