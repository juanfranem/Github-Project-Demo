package es.jfechevarria.application.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import es.jfechevarria.application.core.BasePagingAdapter
import es.jfechevarria.application.databinding.ItemProjectBinding
import es.jfechevarria.application.ui.interfaces.ProjectInteractor
import es.jfechevarria.application.ui.viewHolders.ProjectViewHolder
import es.jfechevarria.domain.project.Project

class ProjectAdapter(
    private val projectInteractor: ProjectInteractor
): BasePagingAdapter<Project, ProjectViewHolder>(object: DiffUtil.ItemCallback<Project>() {
    override fun areItemsTheSame(oldItem: Project, newItem: Project): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Project, newItem: Project): Boolean {
        return oldItem == newItem
    }

}) {
    override fun createViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): ProjectViewHolder {
        return ProjectViewHolder(projectInteractor, ItemProjectBinding.inflate(inflater, parent, false))
    }

}