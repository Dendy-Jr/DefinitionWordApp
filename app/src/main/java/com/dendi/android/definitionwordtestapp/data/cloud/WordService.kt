package com.dendi.android.definitionwordtestapp.data.cloud

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
interface WordService {
    @GET("api/v2/entries/en/{hello}")
    suspend fun fetchWordDefinition(@Path("hello") word: String): Response<List<CloudWord.Base>>
}