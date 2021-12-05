package com.dendi.android.definitionwordtestapp.presentation.adapter

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.dendi.android.definitionwordtestapp.R
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.presentation.UiPhonetic
import com.dendi.android.definitionwordtestapp.presentation.core.BaseViewHolder

/**
 * @author Dendy-Jr on 04.12.2021
 * olehvynnytskyi@gmail.com
 */
abstract class PhoneticsViewHolder(view: View) : BaseViewHolder<UiPhonetic>(view) {

    class Base(view: View) : BaseViewHolder<UiPhonetic>(view) {

        private val textView = itemView.findViewById<TextView>(R.id.text_phonetic)
        private val audioView = itemView.findViewById<ImageButton>(R.id.play_audio)

        override fun bind(item: UiPhonetic) {
            item.mapper(object : Abstract.PhoneticMapper<Unit> {
                override fun map(id: Long, audio: String, text: String) {
                    textView.text = text
                    if (audio.isEmpty()) {
                        audioView.visibility = View.GONE
                    }

                    audioView.setOnClickListener {
                        val mediaPlayer = MediaPlayer().apply {
                            setAudioAttributes(
                                AudioAttributes.Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build()
                            )
                        }
                        try {
                            with(mediaPlayer) {
                                setDataSource(audio.replace(audio, "https:$audio"))
                                prepare()
                                start()
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }
            })
        }
    }
}