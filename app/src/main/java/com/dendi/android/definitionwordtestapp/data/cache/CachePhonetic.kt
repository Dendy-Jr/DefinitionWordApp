package com.dendi.android.definitionwordtestapp.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.DataPhonetic

/**
 * @author Dendy-Jr on 04.12.2021
 * olehvynnytskyi@gmail.com
 */

@Entity(tableName = "phonetic_table")
data class CachePhonetic(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "audio")
    val audio: String,
    @ColumnInfo(name = "text")
    val text: String
) : Abstract.Object<DataPhonetic, Abstract.PhoneticMapper<DataPhonetic>> {
    override fun mapper(mapper: Abstract.PhoneticMapper<DataPhonetic>) =
        mapper.map(id = id, audio = audio, text = text)
}