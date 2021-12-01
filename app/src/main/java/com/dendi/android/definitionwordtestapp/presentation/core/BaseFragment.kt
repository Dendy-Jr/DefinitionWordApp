package com.dendi.android.definitionwordtestapp.presentation.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * @author Dendy-Jr on 30.11.2021
 * olehvynnytskyi@gmail.com
 */

typealias Inflate<S> = (LayoutInflater, ViewGroup?, Boolean) -> S

abstract class BaseFragment<VB : ViewBinding>(private val inflate: Inflate<VB>) : Fragment() {

    private var _viewBinding: VB? = null
    val viewBinding get() = _viewBinding!!

    protected abstract fun setRecyclerView(): RecyclerView
    private var recyclerView: RecyclerView? = null
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = inflate.invoke(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutManager = LinearLayoutManager(requireContext())
        recyclerView = setRecyclerView()
        recyclerView?.layoutManager = layoutManager
        recyclerView?.apply {
            setHasFixedSize(true)
            itemAnimator?.changeDuration = 0
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    protected fun setAdapter(adapter: RecyclerView.Adapter<*>) {
        recyclerView?.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }
}