package com.dendi.android.definitionwordtestapp.domain

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.WordsRepository

/**
 * @author Dendy-Jr on 28.11.2021
 * olehvynnytskyi@gmail.com
 */
interface WordsInteractor {

    suspend fun readOnlineData(word: String): DomainWords

    suspend fun readOfflineData(word: String): DomainWords

    data class Base(
        private val repository: WordsRepository,
        private val mapper: Abstract.WordsDataToDomainMapper
    ) : WordsInteractor {

        override suspend fun readOnlineData(word: String) =
            repository.readDataFromCloud(word).mapper(mapper)

        override suspend fun readOfflineData(word: String) =
            repository.readDataFromDb(word).mapper(mapper)
    }
}