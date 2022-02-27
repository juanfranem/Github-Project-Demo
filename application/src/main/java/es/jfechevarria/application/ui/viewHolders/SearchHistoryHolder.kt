package es.jfechevarria.application.ui.viewHolders

import coil.load
import es.jfechevarria.application.core.BaseViewHolder
import es.jfechevarria.application.databinding.ItemSearchHistoryBinding
import es.jfechevarria.domain.searchHistory.SearchHistory

class SearchHistoryHolder(
    private val binding: ItemSearchHistoryBinding
): BaseViewHolder<SearchHistory>(binding) {
    override fun bind(item: SearchHistory) {
        binding.username.text = item.query
    }
}