package com.dendi.android.definitionwordtestapp.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.cloud.BaseToDataMeaningMapper

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
interface CacheWord {

    fun <T> map(mapper: Abstract.ToDataWordMapper<T>): T

    @Entity(tableName = "word_table")
    data class Base(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        @ColumnInfo(name = "word")
        val word: String,
        @ColumnInfo(name = "phonetic")
        val phonetic: String,
        @ColumnInfo(name = "origin")
        val origin: String,
        @ColumnInfo(name = "meanings")
        val meanings: List<CacheMeaning.Base>
    ) : CacheWord {
        override fun <T> map(mapper: Abstract.ToDataWordMapper<T>): T =
            mapper.map(
                id,
                word,
                phonetic,
                origin,
                meanings.map { it.map(BaseToDataMeaningMapper()) }
            )

    }
}