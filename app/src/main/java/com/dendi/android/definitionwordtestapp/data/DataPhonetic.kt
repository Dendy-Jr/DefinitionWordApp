package com.dendi.android.definitionwordtestapp.data

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.domain.DomainPhonetic

/**
 * @author Dendy-Jr on 04.12.2021
 * olehvynnytskyi@gmail.com
 */

data class DataPhonetic(
    private val id: Long,
    private val audio: String,
    private val text: String
) : Abstract.Object<DomainPhonetic, Abstract.PhoneticMapper<DomainPhonetic>> {
    override fun mapper(mapper: Abstract.PhoneticMapper<DomainPhonetic>) =
        mapper.map(id = id, audio = audio, text = text)
}