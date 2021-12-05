package com.dendi.android.definitionwordtestapp.presentation

import android.os.Parcelable
import com.dendi.android.definitionwordtestapp.core.Abstract
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */

@Parcelize
data class UiDefinition(
    private val id: Long,
    private val antonyms: @RawValue List<Any>,
    private val definition: String,
    private val example: String,
    private val synonyms: List<String>
) : Abstract.Object<Unit, Abstract.DefinitionMapper<Unit>>, Parcelable {
    override fun mapper(mapper: Abstract.DefinitionMapper<Unit>) =
        mapper.map(
            id = id,
            antonyms = antonyms,
            definition = definition,
            example = example,
            synonyms = synonyms
        )
}
