package com.dendi.android.definitionwordtestapp.presentation.di.module

import android.content.Context
import androidx.room.Room
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.cache.CacheWord
import com.dendi.android.definitionwordtestapp.data.cache.CacheDataSource
import com.dendi.android.definitionwordtestapp.data.cache.db.WordDao
import com.dendi.android.definitionwordtestapp.data.cache.db.WordsDatabase
import dagger.Module
import dagger.Provides

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
@Module
class CacheModule {

    private companion object {
        private const val DATABASE_NAME = "words_db"
    }

    @Provides
    fun provideWordsDatabase(context: Context): WordsDatabase {
        return Room.databaseBuilder(
            context,
            WordsDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideWordDao(wordsDatabase: WordsDatabase): WordDao {
        return wordsDatabase.dao()
    }

    @Provides
    fun provideCacheDataSource(
        dao: WordDao,
        mapper: Abstract.ToCacheWordMapper<CacheWord.Base>
    ): CacheDataSource {
        return CacheDataSource.Base(dao, mapper)
    }


}