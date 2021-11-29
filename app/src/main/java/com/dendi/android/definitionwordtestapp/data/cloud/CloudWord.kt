package com.dendi.android.definitionwordtestapp.data.cloud


import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.cache.BaseToCacheMeaningMapper
import com.google.gson.annotations.SerializedName

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
interface CloudWord {

    fun <T> map(mapper: Abstract.ToCacheWordMapper<T>): T

    data class Base(
        @SerializedName("word")
        private val word: String = "",
        @SerializedName("phonetic")
        private val phonetic: String = "",
        @SerializedName("origin")
        private val origin: String = "",
        @SerializedName("meanings")
        private val meanings: List<CloudMeaning.Base> = listOf()
    ) : CloudWord {
        override fun <T> map(mapper: Abstract.ToCacheWordMapper<T>): T  =
            mapper.map(
                0,
                word,
                phonetic,
                origin,
                meanings.map { it.map(BaseToCacheMeaningMapper()) }
            )
    }
}