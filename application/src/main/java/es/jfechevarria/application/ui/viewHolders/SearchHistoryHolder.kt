package es.jfechevarria.application.ui.viewHolders

import es.jfechevarria.application.core.BaseViewHolder
import es.jfechevarria.application.databinding.ItemSearchHistoryBinding
import es.jfechevarria.application.ui.interfaces.HistoricInteractor
import es.jfechevarria.domain.searchHistory.SearchHistory

class SearchHistoryHolder(
    private val historicInteractor: HistoricInteractor,
    private val binding: ItemSearchHistoryBinding
): BaseViewHolder<SearchHistory>(binding) {
    override fun bind(item: SearchHistory) {
        binding.username.text = item.query
        binding.root.setOnClickListener {
            historicInteractor.onSearchHistoricClick(item)
        }
    }
}