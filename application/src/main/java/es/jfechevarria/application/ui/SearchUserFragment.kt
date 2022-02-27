package es.jfechevarria.application.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import es.jfechevarria.application.core.BaseFragment
import es.jfechevarria.application.databinding.FragmentSearchUserBinding
import es.jfechevarria.application.ui.adapters.SearchHistoryAdapter
import es.jfechevarria.application.ui.adapters.UserAdapter
import es.jfechevarria.application.viewmodels.SearchHistoryViewModel
import es.jfechevarria.application.viewmodels.UserViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchUserFragment: BaseFragment<FragmentSearchUserBinding>() {

    private val searchHistoryViewModel: SearchHistoryViewModel by viewModel()
    private val userViewModel: UserViewModel by viewModel()

    private val userAdapter: UserAdapter = UserAdapter()
    private val searchHistoryAdapter: SearchHistoryAdapter = SearchHistoryAdapter()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchUserBinding
        get() = FragmentSearchUserBinding::inflate

    override fun setup() {
        bindViews()
        searchHistoryViewModel.searchHistoryData.observe(this) {
            searchHistoryAdapter.submitList(it)
        }

    }

    private fun bindViews() {
        binding.searchQueryUserName.doOnTextChanged { text, start, before, count ->
            if (text.toString().count() > 3) {
                binding.searchRecyclerView.adapter = userAdapter
                userViewModel.getUserSearchData(text.toString()).observe(this) {
                    userAdapter.submitData(lifecycle, it)
                }
                searchHistoryViewModel.saveSearch(text.toString())
            } else {
                binding.searchRecyclerView.adapter = searchHistoryAdapter
                searchHistoryViewModel.obtainSearchHistory()
            }
        }
    }
}