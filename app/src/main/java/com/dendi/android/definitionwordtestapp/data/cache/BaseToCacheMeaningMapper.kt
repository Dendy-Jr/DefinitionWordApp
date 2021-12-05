package com.dendi.android.definitionwordtestapp.data.cache

import com.dendi.android.definitionwordtestapp.core.Abstract

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
class BaseToCacheMeaningMapper : Abstract.ToCacheMeaningMapper {
    override fun map(id: Long, partOfSpeech: String, definitions: List<CacheDefinition>) =
        CacheMeaning(id = id, partOfSpeech = partOfSpeech, definitions = definitions)
}