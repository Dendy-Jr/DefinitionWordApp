package com.dendi.android.definitionwordtestapp.data.cache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dendi.android.definitionwordtestapp.data.cache.CacheDefinition
import com.dendi.android.definitionwordtestapp.data.cache.CacheMeaning
import com.dendi.android.definitionwordtestapp.data.cache.CacheWord

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
@Database(
    entities = [
        CacheWord.Base::class,
        CacheMeaning.Base::class,
        CacheDefinition.Base::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Convertors::class)
abstract class WordsDatabase : RoomDatabase() {

    abstract fun dao(): WordDao

    companion object {
        private var instance: WordsDatabase? = null

        @Synchronized
        fun database(context: Context): WordsDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordsDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return instance!!
        }

        private const val DATABASE_NAME = "words_db"
    }
}