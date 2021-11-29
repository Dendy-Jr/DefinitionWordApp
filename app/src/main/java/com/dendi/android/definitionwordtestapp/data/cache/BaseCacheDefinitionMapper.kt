package com.dendi.android.definitionwordtestapp.data.cache

import com.dendi.android.definitionwordtestapp.core.Abstract

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
class BaseCacheDefinitionMapper : Abstract.DefinitionMapper<CacheDefinition.Base> {
    override fun map(
        id: Long,
        antonyms: List<Any>,
        definition: String,
        example: String,
        synonyms: List<String>
    ) = CacheDefinition.Base(id, antonyms, definition, example, synonyms)
}