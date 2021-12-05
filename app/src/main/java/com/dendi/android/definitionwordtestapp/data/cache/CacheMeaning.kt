package com.dendi.android.definitionwordtestapp.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.DataMeaning
import com.dendi.android.definitionwordtestapp.data.cloud.BaseDataDefinitionMapper

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */

@Entity(tableName = "meaning_table")
data class CacheMeaning(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "partOfSpeech")
    val partOfSpeech: String,
    @ColumnInfo(name = "definitions")
    val definitions: List<CacheDefinition>
) : Abstract.Object<DataMeaning, Abstract.ToDataMeaningMapper> {
    override fun mapper(mapper: Abstract.ToDataMeaningMapper) =
        mapper.map(
            id = id,
            partOfSpeech = partOfSpeech,
            definitions = definitions.map { it.mapper(BaseDataDefinitionMapper()) })
}