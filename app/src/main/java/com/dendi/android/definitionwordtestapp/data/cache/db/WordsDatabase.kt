package com.dendi.android.definitionwordtestapp.data.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dendi.android.definitionwordtestapp.data.cache.CacheDefinition
import com.dendi.android.definitionwordtestapp.data.cache.CacheMeaning
import com.dendi.android.definitionwordtestapp.data.cache.CachePhonetic
import com.dendi.android.definitionwordtestapp.data.cache.CacheWord

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
@Database(
    entities = [
        CacheWord::class,
        CacheMeaning::class,
        CacheDefinition::class,
        CachePhonetic::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Convertors::class)
abstract class WordsDatabase : RoomDatabase() {

    abstract fun dao(): WordDao
}