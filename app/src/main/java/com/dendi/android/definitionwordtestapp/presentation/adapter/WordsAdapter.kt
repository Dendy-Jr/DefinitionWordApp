package com.dendi.android.definitionwordtestapp.presentation.adapter

import android.view.ViewGroup
import com.dendi.android.definitionwordtestapp.R
import com.dendi.android.definitionwordtestapp.presentation.core.ClickListener
import com.dendi.android.definitionwordtestapp.presentation.UiMeaning
import com.dendi.android.definitionwordtestapp.presentation.UiWord
import com.dendi.android.definitionwordtestapp.presentation.core.BaseAdapter
import com.dendi.android.definitionwordtestapp.presentation.core.BaseViewHolder
import com.dendi.android.definitionwordtestapp.presentation.core.DiffUtilCallback

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
class WordsAdapter(
    private val listenerMeaning: ClickListener<List<UiMeaning>>,
) : BaseAdapter<UiWord, BaseViewHolder<UiWord>>() {

    override fun getItemViewType(position: Int) = when (list[position]) {
        is UiWord.Base -> 0
        is UiWord.Failure -> 1
        is UiWord.Progress -> 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        0 -> WordsViewHolder.Base(
            R.layout.word_item.makeView(parent),
            listenerMeaning,
        )
        1 -> WordsViewHolder.Fail(R.layout.fail_fullscreen.makeView(parent))
        2 -> BaseViewHolder.FullScreenProgress(R.layout.progress_fullscreen.makeView(parent))
        else -> throw IllegalStateException("unknown viewType $viewType")
    }

    override fun diffUtilCallback(list: ArrayList<UiWord>, data: List<UiWord>) =
        WordDiffUtilCallback(list, data)

    inner class WordDiffUtilCallback(
        oldList: List<UiWord>,
        newList: List<UiWord>,
    ) : DiffUtilCallback<UiWord>(oldList, newList)
}