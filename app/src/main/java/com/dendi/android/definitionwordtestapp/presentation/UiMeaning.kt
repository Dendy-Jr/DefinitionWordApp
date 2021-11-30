package com.dendi.android.definitionwordtestapp.presentation

import android.os.Parcelable
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.presentation.core.ClickListener
import kotlinx.android.parcel.Parcelize


/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
interface UiMeaning {

    fun <T> map(mapper: Abstract.UiMeaningMapper<T>): T

    fun map(listener: ClickListener<List<UiDefinition.Base>>) = Unit

    @Parcelize
    data class Base(
        private val id: Long,
        private val partOfSpeech: String,
        private val definitions: List<UiDefinition.Base>
    ) : UiMeaning, Parcelable {
        override fun <T> map(mapper: Abstract.UiMeaningMapper<T>): T =
            mapper.map(id, partOfSpeech, definitions)

        override fun map(listener: ClickListener<List<UiDefinition.Base>>) =
            listener.click(definitions)
    }
}