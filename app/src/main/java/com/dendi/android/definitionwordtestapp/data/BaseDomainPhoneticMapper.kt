package com.dendi.android.definitionwordtestapp.data

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.domain.DomainPhonetic

/**
 * @author Dendy-Jr on 04.12.2021
 * olehvynnytskyi@gmail.com
 */
class BaseDomainPhoneticMapper : Abstract.PhoneticMapper<DomainPhonetic> {
    override fun map(id: Long, audio: String, text: String) =
        DomainPhonetic(id = id, audio = audio, text = text)
}