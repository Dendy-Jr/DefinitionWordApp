package com.dendi.android.definitionwordtestapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.core.ClickListener
import com.dendi.android.definitionwordtestapp.databinding.MeaningItemBinding
import com.dendi.android.definitionwordtestapp.presentation.UiDefinition
import com.dendi.android.definitionwordtestapp.presentation.UiMeaning

/**
 * @author Dendy-Jr on 30.11.2021
 * olehvynnytskyi@gmail.com
 */
class MeaningAdapter(private val listener: ClickListener<List<UiDefinition.Base>>) :
    RecyclerView.Adapter<MeaningAdapter.MeaningViewHolder>(), Abstract.ListMapper<UiMeaning> {

    private val meanings = ArrayList<UiMeaning>()

    override fun map(data: List<UiMeaning>) {
        meanings.clear()
        meanings.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeaningViewHolder {
        val binding = MeaningItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MeaningViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: MeaningViewHolder, position: Int) {
        holder.bind(meanings[position])
    }

    override fun getItemCount() = meanings.size

    inner class MeaningViewHolder(
        private val binding: MeaningItemBinding,
        private val listener: ClickListener<List<UiDefinition.Base>>
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(meaning: UiMeaning) {
            meaning.map(object : Abstract.UiMeaningMapper<Unit> {
                override fun map(
                    id: Long,
                    partOfSpeech: String,
                    definitions: List<UiDefinition.Base>
                ) {
                    binding.partOfSpeech.text = partOfSpeech
                }
            })
            itemView.setOnClickListener {
                meaning.map(listener)
            }
        }
    }
}