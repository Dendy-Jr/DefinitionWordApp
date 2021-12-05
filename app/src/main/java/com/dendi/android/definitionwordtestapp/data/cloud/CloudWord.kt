package com.dendi.android.definitionwordtestapp.data.cloud


import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.cache.BaseToCacheMeaningMapper
import com.dendi.android.definitionwordtestapp.data.cache.CacheWord
import com.google.gson.annotations.SerializedName

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
data class CloudWord(
    @SerializedName("word")
    private val word: String = "",
    @SerializedName("phonetic")
    private val phonetic: String = "",
    @SerializedName("phonetics")
    private val phonetics: List<CloudPhonetic> = listOf(),
    @SerializedName("origin")
    private val origin: String = "",
    @SerializedName("meanings")
    private val meanings: List<CloudMeaning> = listOf()
) : Abstract.Object<CacheWord, Abstract.ToCacheWordMapper> {
    override fun mapper(mapper: Abstract.ToCacheWordMapper) =
        mapper.map(
            id = 0,
            word = word,
            phonetic = phonetic,
            phonetics = phonetics.map { it.mapper(BaseCachePhoneticMapper()) },
            origin = origin,
            meanings = meanings.map { it.mapper(BaseToCacheMeaningMapper()) }
        )
}
