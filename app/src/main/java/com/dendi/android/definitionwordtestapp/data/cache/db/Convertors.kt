package com.dendi.android.definitionwordtestapp.data.cache.db

import androidx.room.TypeConverter
import com.dendi.android.definitionwordtestapp.data.cache.CacheDefinition
import com.dendi.android.definitionwordtestapp.data.cache.CacheMeaning
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
class Convertors {

    @TypeConverter
    fun fromMeaning(meaning: List<CacheMeaning.Base>): String {
        val type = object : TypeToken<List<CacheMeaning.Base>>() {}.type
        return Gson().toJson(meaning, type)
    }

    @TypeConverter
    fun toMeaning(json: String): List<CacheMeaning.Base> {
        val type = object : TypeToken<List<CacheMeaning.Base>>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun fromDefinition(definition: List<CacheDefinition.Base>): String {
        val type = object : TypeToken<List<CacheDefinition.Base>>() {}.type
        return Gson().toJson(definition, type)
    }

    @TypeConverter
    fun toDefinition(json: String): List<CacheDefinition.Base> {
        val type = object : TypeToken<List<CacheDefinition.Base>>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun fromAntonyms(definition: List<Any>): String {
        val type = object : TypeToken<List<Any>>() {}.type
        return Gson().toJson(definition, type)
    }

    @TypeConverter
    fun toAntonyms(json: String): List<Any> {
        val type = object : TypeToken<List<Any>>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun fromSynonyms(definition: List<String>): String {
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().toJson(definition, type)
    }

    @TypeConverter
    fun toSynonyms(json: String): List<String> {
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(json, type)
    }
}