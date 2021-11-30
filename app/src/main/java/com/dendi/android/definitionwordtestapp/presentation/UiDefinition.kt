package com.dendi.android.definitionwordtestapp.presentation

import android.os.Parcelable
import com.dendi.android.definitionwordtestapp.core.Abstract
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
interface UiDefinition {

    fun <T> map(mapper: Abstract.DefinitionMapper<T>): T

    @Parcelize
    data class Base(
        private val id: Long,
        private val antonyms: @RawValue List<Any>,
        private val definition: String,
        private val example: String,
        private val synonyms: List<String>
    ) : UiDefinition, Parcelable {
        override fun <T> map(mapper: Abstract.DefinitionMapper<T>): T =
            mapper.map(id, antonyms, definition, example, synonyms)
    }
}