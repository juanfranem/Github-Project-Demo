package es.jfechevarria.application.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import es.jfechevarria.application.R
import es.jfechevarria.application.core.BaseFragment
import es.jfechevarria.application.databinding.FragmentSearchUserBinding
import es.jfechevarria.application.ui.interfaces.HistoricInteractor
import es.jfechevarria.application.ui.interfaces.UserInteractor
import es.jfechevarria.application.ui.adapters.SearchHistoryAdapter
import es.jfechevarria.application.ui.adapters.UserAdapter
import es.jfechevarria.application.data.viewmodels.SearchHistoryViewModel
import es.jfechevarria.application.data.viewmodels.UserViewModel
import es.jfechevarria.domain.searchHistory.SearchHistory
import es.jfechevarria.domain.user.User
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchUserFragment: BaseFragment<FragmentSearchUserBinding>(), HistoricInteractor, UserInteractor {

    private val searchHistoryViewModel: SearchHistoryViewModel by viewModel()
    private val userViewModel: UserViewModel by viewModel()

    private val userAdapter: UserAdapter = UserAdapter(this)
    private val searchHistoryAdapter: SearchHistoryAdapter = SearchHistoryAdapter(this)

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchUserBinding
        get() = FragmentSearchUserBinding::inflate

    override fun setup() {
        bindViews()
        binding.searchRecyclerView.adapter = searchHistoryAdapter
        searchHistoryViewModel.searchHistoryData.observe(this) {
            searchHistoryAdapter.submitList(it)
        }
        userViewModel.pageSource.observe(this) {
            userAdapter.submitData(lifecycle, it)
        }
    }

    private fun bindViews() {
        binding.searchQueryUserName.doOnTextChanged { text, _, _, _ ->
            if (text.toString().count() > 3) {
                binding.searchRecyclerView.adapter = userAdapter
                userViewModel.setQuery(text.toString())
                searchHistoryViewModel.saveSearch(text.toString())
                binding.textResultsFor.text = resources.getString(R.string.results_for, text.toString())
            } else {
                binding.searchRecyclerView.adapter = searchHistoryAdapter
                searchHistoryViewModel.obtainSearchHistory()
                binding.textResultsFor.text = resources.getText(R.string.latest_search)
            }
        }
    }

    override fun onSearchHistoricClick(searchHistory: SearchHistory) {
        binding.searchQueryUserName.setText(searchHistory.query)
    }

    override fun onUserClick(user: User) {
        findNavController().navigate(
            SearchUserFragmentDirections.actionSearchToListRepositories(user)
        )
    }
}