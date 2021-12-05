package com.dendi.android.definitionwordtestapp.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.DataWord
import com.dendi.android.definitionwordtestapp.data.cloud.BaseDataPhoneticMapper
import com.dendi.android.definitionwordtestapp.data.cloud.BaseToDataMeaningMapper

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */

@Entity(tableName = "word_table")
data class CacheWord(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "word")
    val word: String,
    @ColumnInfo(name = "phonetic")
    val phonetic: String,
    @ColumnInfo(name = "phonetics")
    val phonetics: List<CachePhonetic>,
    @ColumnInfo(name = "origin")
    val origin: String,
    @ColumnInfo(name = "meanings")
    val meanings: List<CacheMeaning>
) : Abstract.Object<DataWord, Abstract.ToDataWordMapper> {
    override fun mapper(mapper: Abstract.ToDataWordMapper) =
        mapper.map(
            id = id,
            word = word,
            phonetic = phonetic,
            phonetics = phonetics.map { it.mapper(BaseDataPhoneticMapper()) },
            origin = origin,
            meanings = meanings.map { it.mapper(BaseToDataMeaningMapper()) }
        )
}