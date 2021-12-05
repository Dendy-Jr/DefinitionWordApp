package com.dendi.android.definitionwordtestapp.data.cloud


import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.cache.CacheDefinition
import com.google.gson.annotations.SerializedName

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */

data class CloudDefinition(
    @SerializedName("antonyms")
    private val antonyms: List<Any> = listOf(),
    @SerializedName("definition")
    private val definition: String = "",
    @SerializedName("example")
    private val example: String = "",
    @SerializedName("synonyms")
    private val synonyms: List<String> = listOf()
) : Abstract.Object<CacheDefinition, Abstract.DefinitionMapper<CacheDefinition>> {
    override fun mapper(mapper: Abstract.DefinitionMapper<CacheDefinition>) =
        mapper.map(
            id = 0,
            antonyms = antonyms,
            definition = definition,
            example = example,
            synonyms = synonyms
        )
}