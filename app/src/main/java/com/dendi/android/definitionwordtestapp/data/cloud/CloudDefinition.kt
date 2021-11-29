package com.dendi.android.definitionwordtestapp.data.cloud


import com.dendi.android.definitionwordtestapp.core.Abstract
import com.google.gson.annotations.SerializedName
/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
interface CloudDefinition {

    fun <T> map(mapper: Abstract.DefinitionMapper<T>): T

    data class Base(
        @SerializedName("antonyms")
        private val antonyms: List<Any> = listOf(),
        @SerializedName("definition")
        private val definition: String = "",
        @SerializedName("example")
        private val example: String = "",
        @SerializedName("synonyms")
        private val synonyms: List<String> = listOf()
    ) : CloudDefinition {
        override fun <T> map(mapper: Abstract.DefinitionMapper<T>): T =
            mapper.map(0, antonyms, definition, example, synonyms)
    }
}