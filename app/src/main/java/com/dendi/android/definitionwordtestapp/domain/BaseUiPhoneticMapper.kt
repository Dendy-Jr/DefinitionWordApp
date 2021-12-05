package com.dendi.android.definitionwordtestapp.domain

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.presentation.UiPhonetic

/**
 * @author Dendy-Jr on 04.12.2021
 * olehvynnytskyi@gmail.com
 */
class BaseUiPhoneticMapper : Abstract.PhoneticMapper<UiPhonetic> {
    override fun map(id: Long, audio: String, text: String) =
        UiPhonetic(id = id, audio = audio, text = text)
}