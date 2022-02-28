package es.jfechevarria.application.ui.viewHolders

import android.text.format.DateUtils
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import es.jfechevarria.application.MainActivity
import es.jfechevarria.application.R
import es.jfechevarria.application.core.BaseViewHolder
import es.jfechevarria.application.databinding.ItemProjectBinding
import es.jfechevarria.application.ui.interfaces.ProjectInteractor
import es.jfechevarria.domain.project.Project
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class ProjectViewHolder(
    private val projectInteractor: ProjectInteractor,
    private val binding: ItemProjectBinding
): BaseViewHolder<Project>(binding) {
    private val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())

    override fun bind(item: Project) {
        binding.name.text = item.name
        binding.description.text = item.description
        binding.privateLogo.isVisible = item.private
        binding.language.text = (item.language ?: binding.root.resources.getString(R.string.undefined)).replaceFirstChar { it.uppercase() }
        if (item.forked) {
            binding.forked.background = ResourcesCompat.getDrawable(binding.root.context.resources, R.drawable.oval_forked, (binding.root.context as MainActivity).theme)
            binding.forked.text = item.forksCount.toString()
        } else {
            binding.forked.background = ResourcesCompat.getDrawable(binding.root.context.resources, R.drawable.oval_no_forked, (binding.root.context as MainActivity).theme)
            binding.forked.text = null
        }
         try {
             val timeSince = df.parse(item.updatedDate)
            timeSince?.let {
                val niceDate = DateUtils.getRelativeTimeSpanString(timeSince.time)
                binding.updated.text = niceDate
            } ?: run {
                binding.updated.setText(R.string.not_available)
            }
        } catch (e: Exception) {
             binding.updated.setText(R.string.not_available)
        }
        binding.root.setOnClickListener {
            projectInteractor.onProjectClick(item)
        }
        binding.root.setOnLongClickListener {
            projectInteractor.onProjectLongClick(item)
            true
        }
    }
}