package com.example.demo.app.core.ui.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.app.core.ui.adapter.model.ListItem

abstract class MultiTypeViewHolder<M : ListItem>(root: View) : RecyclerView.ViewHolder(root) {

    protected lateinit var model: M

    abstract fun bind(model: M)

    open fun bindPayload(model: M, payloads: List<Any>) {
        this.model = model
        bind(model)
    }

    fun onBind(model: M) {
        this.model = model
        bind(model)
    }
}