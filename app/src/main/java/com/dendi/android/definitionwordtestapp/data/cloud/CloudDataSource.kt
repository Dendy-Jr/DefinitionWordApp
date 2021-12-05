package com.dendi.android.definitionwordtestapp.data.cloud

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */

interface CloudDataSource {

    suspend fun fetchWordDefinition(word: String): List<CloudWord>

    class Base(private val service: WordService) : CloudDataSource {
        override suspend fun fetchWordDefinition(word: String) =
            service.fetchWordDefinition(word).body()!!
    }
}

