package com.dendi.android.definitionwordtestapp.presentation

import android.os.Parcelable
import com.dendi.android.definitionwordtestapp.core.Abstract
import kotlinx.android.parcel.Parcelize

/**
 * @author Dendy-Jr on 04.12.2021
 * olehvynnytskyi@gmail.com
 */

@Parcelize
data class UiPhonetic(
    private val id: Long,
    private val audio: String,
    private val text: String
) : Abstract.Object<Unit, Abstract.PhoneticMapper<Unit>>, Parcelable {
    override fun mapper(mapper: Abstract.PhoneticMapper<Unit>) = mapper.map(
        id = id,
        audio = audio,
        text = text
    )
}
