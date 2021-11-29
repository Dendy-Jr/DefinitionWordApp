package com.dendi.android.definitionwordtestapp.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dendi.android.definitionwordtestapp.core.Abstract

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
interface CacheDefinition {

    fun <T> map(mapper: Abstract.DefinitionMapper<T>): T

    @Entity(tableName = ("definition_table"))
    data class Base(
        @PrimaryKey
        val id: Long,
        @ColumnInfo(name = "antonyms")
        val antonyms: List<Any>,
        @ColumnInfo(name = "definition")
        val definition: String,
        @ColumnInfo(name = "example")
        val example: String,
        @ColumnInfo(name = "synonyms")
        val synonyms: List<String>
    ) : CacheDefinition {
        override fun <T> map(mapper: Abstract.DefinitionMapper<T>): T =
            mapper.map(id, antonyms, definition, example, synonyms)
    }
}