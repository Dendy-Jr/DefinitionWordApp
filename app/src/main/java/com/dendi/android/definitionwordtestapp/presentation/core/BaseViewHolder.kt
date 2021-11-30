package com.dendi.android.definitionwordtestapp.presentation.core

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dendi.android.definitionwordtestapp.R

/**
 * @author Dendy-Jr on 30.11.2021
 * olehvynnytskyi@gmail.com
 */
abstract class BaseViewHolder<E>(view: View) : RecyclerView.ViewHolder(view) {

    open fun bind(item: E) {}

    class FullScreenProgress<E>(view: View) :
        BaseViewHolder<E>(view)

    abstract class Fail<E>(view: View) :
        BaseViewHolder<E>(view) {
        protected val error: TextView = itemView.findViewById(R.id.messageError)
    }
}