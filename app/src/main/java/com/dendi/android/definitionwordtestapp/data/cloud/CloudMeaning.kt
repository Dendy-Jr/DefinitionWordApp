package com.dendi.android.definitionwordtestapp.data.cloud


import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.cache.BaseCacheDefinitionMapper
import com.dendi.android.definitionwordtestapp.data.cache.CacheMeaning
import com.google.gson.annotations.SerializedName

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */


data class CloudMeaning(
    @SerializedName("partOfSpeech")
    private val partOfSpeech: String = "",
    @SerializedName("definitions")
    private val definitions: List<CloudDefinition> = listOf()
) : Abstract.Object<CacheMeaning, Abstract.ToCacheMeaningMapper> {
    override fun mapper(mapper: Abstract.ToCacheMeaningMapper) =
        mapper.map(
            id = 0,
            partOfSpeech = partOfSpeech,
            definitions = definitions.map { it.mapper(mapper = BaseCacheDefinitionMapper()) }
        )
}
