package com.dendi.android.definitionwordtestapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dendi.android.definitionwordtestapp.R
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.presentation.UiWord
import com.dendi.android.definitionwordtestapp.presentation.UiWords

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
class WordAdapter : RecyclerView.Adapter<WordViewHolder>(), Abstract.ListMapper<UiWord> {

    private val words = ArrayList<UiWord>()

    override fun map(data: List<UiWord>) {
        val diffUtilCallback = DiffUtilCallback(words, data)
        val result = DiffUtil.calculateDiff(diffUtilCallback)
        words.clear()
        words.addAll(data)
        result.dispatchUpdatesTo(this)
    }

    override fun getItemViewType(position: Int) = when (words[position]) {
        is UiWord.Base -> 0
        is UiWord.Failure -> 1
        is UiWord.Progress -> 2
        else -> 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder =
        when (viewType) {
            0 -> WordViewHolder.Base(R.layout.word_item.makeView(parent))
            1 -> WordViewHolder.Fail(R.layout.fail_fullscreen.makeView(parent))
            2 -> WordViewHolder.FullscreenProgress(R.layout.progress_fullscreen.makeView(parent))
            else -> throw IllegalStateException("unknown viewType $viewType")
        }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(words[position])
    }

    override fun getItemCount() = words.size

    private fun Int.makeView(parent: ViewGroup): View =
        LayoutInflater.from(parent.context).inflate(this, parent, false)
}