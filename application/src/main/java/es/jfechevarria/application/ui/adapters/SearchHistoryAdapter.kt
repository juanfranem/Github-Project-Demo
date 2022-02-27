package es.jfechevarria.application.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import es.jfechevarria.application.core.BaseAdapter
import es.jfechevarria.application.databinding.ItemSearchHistoryBinding
import es.jfechevarria.application.ui.viewHolders.SearchHistoryHolder
import es.jfechevarria.domain.searchHistory.SearchHistory

class SearchHistoryAdapter: BaseAdapter<SearchHistory, SearchHistoryHolder>(object: DiffUtil.ItemCallback<SearchHistory>() {
    override fun areItemsTheSame(oldItem: SearchHistory, newItem: SearchHistory): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: SearchHistory, newItem: SearchHistory): Boolean {
        return oldItem == newItem
    }

}) {
    override fun createViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): SearchHistoryHolder {
        return SearchHistoryHolder(ItemSearchHistoryBinding.inflate(inflater, parent, false))
    }
}