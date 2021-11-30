package com.dendi.android.definitionwordtestapp.presentation.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dendi.android.definitionwordtestapp.core.Abstract

/**
 * @author Dendy-Jr on 30.11.2021
 * olehvynnytskyi@gmail.com
 */
abstract class BaseAdapter<E, T : BaseViewHolder<E>> : RecyclerView.Adapter<T>(),
    Abstract.ListMapper<E> {

    protected val list = ArrayList<E>()

    override fun map(data: List<E>) {
        val diffCallback = diffUtilCallback(list, data)
        val result = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(data)
        result.dispatchUpdatesTo(this)
    }

    abstract fun diffUtilCallback(list: ArrayList<E>, data: List<E>): DiffUtil.Callback

    override fun onBindViewHolder(holder: T, position: Int) =
        holder.bind(list[position])

    override fun getItemCount() = list.size

    protected fun Int.makeView(parent: ViewGroup): View =
        LayoutInflater.from(parent.context).inflate(this, parent, false)
}