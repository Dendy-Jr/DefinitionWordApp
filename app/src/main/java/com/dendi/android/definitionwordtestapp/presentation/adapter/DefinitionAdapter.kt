package com.dendi.android.definitionwordtestapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.databinding.DefinitionItemBinding
import com.dendi.android.definitionwordtestapp.presentation.UiDefinition

/**
 * @author Dendy-Jr on 30.11.2021
 * olehvynnytskyi@gmail.com
 */
class DefinitionAdapter : RecyclerView.Adapter<DefinitionAdapter.DefinitionViewHolder>(),
    Abstract.ListMapper<UiDefinition> {

    private val definitions = ArrayList<UiDefinition>()

    override fun map(data: List<UiDefinition>) {
        definitions.clear()
        definitions.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefinitionViewHolder {
        val binding =
            DefinitionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DefinitionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DefinitionViewHolder, position: Int) {
        holder.bind(definitions[position])
    }

    override fun getItemCount() = definitions.size

    inner class DefinitionViewHolder(
        private val binding: DefinitionItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(meaning: UiDefinition) {
            meaning.map(object : Abstract.DefinitionMapper<Unit> {
                override fun map(
                    id: Long,
                    antonyms: List<Any>,
                    definition: String,
                    example: String,
                    synonyms: List<String>
                ) {
                    binding.definition.text = definition
                    binding.example.text = example

                    binding.antonyms.text = antonyms.toString().replace("[", "").replace("]", "")
                    binding.synonyms.text = synonyms.toString().replace("[", "").replace("]", "")
                }
            })
        }
    }
}