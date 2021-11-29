package com.dendi.android.definitionwordtestapp.data.cache

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.cache.db.WordDao
import com.dendi.android.definitionwordtestapp.data.cloud.CloudWord

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
interface CacheDataSource {

    suspend fun saveWord(words: List<CloudWord>)

    suspend fun fetchWordDefinition(word: String): List<CacheWord>

    class Base(
        private val dao: WordDao,
        private val mapper: Abstract.ToCacheWordMapper<CacheWord.Base>
    ) : CacheDataSource {

        override suspend fun fetchWordDefinition(word: String) = dao.fetchWordDefinition(word)
        override suspend fun saveWord(words: List<CloudWord>) =
            dao.insert(words.map { it.map(mapper) })
    }
}