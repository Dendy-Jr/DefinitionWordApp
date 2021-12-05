package com.dendi.android.definitionwordtestapp.data.cloud

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.DataPhonetic

/**
 * @author Dendy-Jr on 04.12.2021
 * olehvynnytskyi@gmail.com
 */
class BaseDataPhoneticMapper : Abstract.PhoneticMapper<DataPhonetic> {
    override fun map(id: Long, audio: String, text: String) =
        DataPhonetic(id = id, audio = audio, text = text)
}