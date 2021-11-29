package com.dendi.android.definitionwordtestapp.data.cloud


import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.cache.BaseCacheDefinitionMapper
import com.google.gson.annotations.SerializedName
/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
interface CloudMeaning {

    fun <T> map(mapper: Abstract.ToCacheMeaningMapper<T>): T

    data class Base(
        @SerializedName("partOfSpeech")
        private val partOfSpeech: String = "",
        @SerializedName("definitions")
        private val definitions: List<CloudDefinition.Base> = listOf()
    ) : CloudMeaning {
        override fun <T> map(mapper: Abstract.ToCacheMeaningMapper<T>): T =
            mapper.map(
                0,
                partOfSpeech,
                definitions.map { it.map(BaseCacheDefinitionMapper()) }
            )
    }
}
