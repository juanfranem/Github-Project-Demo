package es.jfechevarria.application.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.res.ResourcesCompat
import androidx.core.net.toUri
import androidx.navigation.fragment.navArgs
import es.jfechevarria.application.R
import es.jfechevarria.application.core.BaseFragment
import es.jfechevarria.application.databinding.FragmentListRepositoriesBinding
import es.jfechevarria.application.ui.extensions.load
import es.jfechevarria.application.ui.interfaces.ProjectInteractor
import es.jfechevarria.application.ui.adapters.ProjectAdapter
import es.jfechevarria.application.ui.dialog.SelectionDialog
import es.jfechevarria.application.data.viewmodels.ProjectViewModel
import es.jfechevarria.domain.project.Project
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ListRepositoriesFragment: BaseFragment<FragmentListRepositoriesBinding>(), ProjectInteractor {

    private val args: ListRepositoriesFragmentArgs by navArgs()
    private val projectViewModel: ProjectViewModel by viewModel { parametersOf(args.user)}
    private val projectAdapter: ProjectAdapter = ProjectAdapter(this)

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentListRepositoriesBinding
        get() = FragmentListRepositoriesBinding::inflate

    override fun setup() {
        bindViews()
        projectViewModel.repositoriesSource.observe(this) {
            projectAdapter.submitData(lifecycle, it)
        }
    }

    private fun bindViews() {
        args.user.let {
            binding.userButton.setOnClickListener {
                openTab(args.user.externalUrl)
            }
            binding.userImage.load(it.image)
            binding.userTitle.text = it.userName
            binding.userUrl.text = it.externalUrl
        }
        binding.projectsRecycler.adapter = projectAdapter
    }

    override fun onProjectClick(project: Project) {
        openTab(project.externalUrl)
    }

    override fun onProjectLongClick(project: Project) {
        SelectionDialog.createSelectionDialog(requireContext(), onOpenProjectPage =  {
            openTab(project.externalUrl)
        }, onOpenUserPage =  {
            openTab(args.user.externalUrl)
        }).show()
    }

    private fun openTab(url: String) {
        val builder = CustomTabsIntent.Builder()

        val defaultColor = CustomTabColorSchemeParams.Builder()
            .setToolbarColor(ResourcesCompat.getColor(resources, R.color.purple_700, requireActivity().theme))
            .build()

        builder.setDefaultColorSchemeParams(defaultColor)
            .setShareState(CustomTabsIntent.SHARE_STATE_ON)
        val intentLauncher = builder.build()
        intentLauncher.launchUrl(requireContext(), url.toUri())
    }
}