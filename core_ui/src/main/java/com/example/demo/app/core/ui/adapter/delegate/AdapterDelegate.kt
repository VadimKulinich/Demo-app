package com.example.demo.app.core.ui.adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.demo.app.core.ui.adapter.holder.MultiTypeViewHolder
import com.example.demo.app.core.ui.adapter.model.ListItem

abstract class AdapterDelegate<M : ListItem, H : MultiTypeViewHolder<M>> {

    abstract val viewType: Int

    abstract fun createHolder(parent: ViewGroup, inflater: LayoutInflater): H

    fun createHolder(parent: ViewGroup): H =
        createHolder(parent, LayoutInflater.from(parent.context))
}