package com.dendi.android.definitionwordtestapp.di.module

import android.app.Application
import androidx.room.Room
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.cache.BaseToCacheWordMapper
import com.dendi.android.definitionwordtestapp.data.cache.CacheDataSource
import com.dendi.android.definitionwordtestapp.data.cache.db.WordDao
import com.dendi.android.definitionwordtestapp.data.cache.db.WordsDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


/**
 * @author Dendy-Jr on 03.12.2021
 * olehvynnytskyi@gmail.com
 */

private const val DATABASE_NAME = "words_db"

val cacheModule = module {

    fun getWordsDatabase(application: Application): WordsDatabase {
        return Room.databaseBuilder(
            application,
            WordsDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    factory<WordsDatabase> {
        getWordsDatabase(application = androidApplication())
    }

    fun getWordDao(wordsDatabase: WordsDatabase): WordDao {
        return wordsDatabase.dao()
    }

    factory<WordDao> {
        getWordDao(wordsDatabase = get())
    }

    fun getCacheDataSource(
        dao: WordDao,
        mapper: Abstract.ToCacheWordMapper
    ): CacheDataSource {
        return CacheDataSource.Base(dao, mapper)
    }

    factory<Abstract.ToCacheWordMapper> {
        BaseToCacheWordMapper()
    }

    factory<CacheDataSource> {
        getCacheDataSource(dao = get(), mapper = get())
    }
}
