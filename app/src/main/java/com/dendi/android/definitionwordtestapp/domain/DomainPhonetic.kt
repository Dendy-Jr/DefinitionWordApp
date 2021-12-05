package com.dendi.android.definitionwordtestapp.domain

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.presentation.UiPhonetic

/**
 * @author Dendy-Jr on 04.12.2021
 * olehvynnytskyi@gmail.com
 */

data class DomainPhonetic(
    private val id: Long,
    private val audio: String,
    private val text: String
) : Abstract.Object<UiPhonetic, Abstract.PhoneticMapper<UiPhonetic>> {
    override fun mapper(mapper: Abstract.PhoneticMapper<UiPhonetic>) = mapper.map(
        id = id,
        audio = audio,
        text = text
    )
}