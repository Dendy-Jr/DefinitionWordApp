package com.dendi.android.definitionwordtestapp.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.dendi.android.definitionwordtestapp.presentation.UiWord

/**
 * @author Dendy-Jr on 28.11.2021
 * olehvynnytskyi@gmail.com
 */
class DiffUtilCallback(
    private val oldList: List<UiWord>,
    private val newList: List<UiWord>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}