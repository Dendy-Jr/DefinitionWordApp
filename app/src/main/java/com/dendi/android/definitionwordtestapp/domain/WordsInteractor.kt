package com.dendi.android.definitionwordtestapp.domain

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.WordsRepository

/**
 * @author Dendy-Jr on 28.11.2021
 * olehvynnytskyi@gmail.com
 */
interface WordsInteractor {

    suspend fun readDataFromCloud(word: String): DomainWords

    suspend fun readDataFromDb(word: String): DomainWords

    data class Base(
        private val repository: WordsRepository,
        private val mapper: Abstract.WordsDataToDomainMapper<DomainWords>
    ) : WordsInteractor {

        override suspend fun readDataFromCloud(word: String) =
            repository.readDataFromCloud(word).map(mapper)

        override suspend fun readDataFromDb(word: String) =
            repository.readDataFromDb(word).map(mapper)
    }
}