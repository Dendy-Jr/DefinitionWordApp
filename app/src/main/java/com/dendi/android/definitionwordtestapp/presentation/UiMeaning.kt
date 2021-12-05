package com.dendi.android.definitionwordtestapp.presentation

import android.os.Parcelable
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.presentation.core.ClickListener
import kotlinx.android.parcel.Parcelize


/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */

@Parcelize
data class UiMeaning(
    private val id: Long,
    private val partOfSpeech: String,
    private val definitions: List<UiDefinition>
) : Abstract.Object<Unit, Abstract.UiMeaningMapper<Unit>>, Parcelable {
    override fun mapper(mapper: Abstract.UiMeaningMapper<Unit>): Unit =
        mapper.map(id, partOfSpeech, definitions)

    fun map(listener: ClickListener<List<UiDefinition>>) = listener.click(definitions)
}