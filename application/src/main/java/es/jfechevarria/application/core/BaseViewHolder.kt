package es.jfechevarria.application.core

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<T: Any>(private val binding: ViewBinding): RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item: T)
}