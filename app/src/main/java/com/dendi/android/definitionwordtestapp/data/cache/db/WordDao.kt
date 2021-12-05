package com.dendi.android.definitionwordtestapp.data.cache.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dendi.android.definitionwordtestapp.data.cache.CacheWord

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(cacheWord: List<CacheWord>)

    @Query("SELECT * FROM word_table where word = :word")
     fun fetchWordDefinition(word: String): List<CacheWord>
}