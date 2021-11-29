package com.dendi.android.definitionwordtestapp.data

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.core.ExceptionMapper
import com.dendi.android.definitionwordtestapp.data.cache.CacheDataSource
import com.dendi.android.definitionwordtestapp.data.cache.CacheWord
import com.dendi.android.definitionwordtestapp.data.cloud.CloudDataSource

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
interface WordsRepository {

    suspend fun readDataFromCloud(word: String): DataWords

    suspend fun readDataFromDb(word: String): DataWords

    class Base(
        private val cloudDataSource: CloudDataSource,
        private val cacheDataSource: CacheDataSource,
        private val mapperCache: Abstract.ToCacheWordMapper<CacheWord.Base>,
        private val mapperData: Abstract.ToDataWordMapper<DataWord.Base>,
        private val exceptionMapper: ExceptionMapper
    ) : WordsRepository {

        override suspend fun readDataFromCloud(word: String) = try {
            val responseData = cloudDataSource.fetchWordDefinition(word)
            val words = responseData.map { it.map(mapperCache) }
            cacheDataSource.saveWord(responseData)
            DataWords.Success(words.map { it.map(mapperData) })
        } catch (e: Exception) {
            DataWords.Failure(exceptionMapper.map(e))
        }

        override suspend fun readDataFromDb(word: String) =
            DataWords.Success(cacheDataSource.fetchWordDefinition(word).map { it.map(mapperData) })
    }
}

