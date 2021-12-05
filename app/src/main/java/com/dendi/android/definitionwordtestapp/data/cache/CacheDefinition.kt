package com.dendi.android.definitionwordtestapp.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.DataDefinition

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */

@Entity(tableName = ("definition_table"))
data class CacheDefinition(
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
) : Abstract.Object<DataDefinition, Abstract.DefinitionMapper<DataDefinition>> {
    override fun mapper(mapper: Abstract.DefinitionMapper<DataDefinition>) =
        mapper.map(
            id = id,
            antonyms = antonyms,
            definition = definition,
            example = example,
            synonyms = synonyms
        )
}