package com.dendi.android.definitionwordtestapp.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.cloud.BaseDataDefinitionMapper
import com.dendi.android.definitionwordtestapp.data.cloud.CloudDefinition

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
interface CacheMeaning {

    fun <T> map(mapper: Abstract.ToDataMeaningMapper<T>): T

    @Entity(tableName = "meaning_table")
    data class Base(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        @ColumnInfo(name = "partOfSpeech")
        val partOfSpeech: String,
        @ColumnInfo(name = "definitions")
        val definitions: List<CacheDefinition.Base>
    ) : CacheMeaning {
        override fun <T> map(mapper: Abstract.ToDataMeaningMapper<T>): T =
            mapper.map(id, partOfSpeech, definitions.map { it.map(BaseDataDefinitionMapper()) })
    }
}