package es.jfechevarria.application.ui.interfaces

import es.jfechevarria.domain.project.Project

interface ProjectInteractor {
    fun onProjectClick(project: Project)
    fun onProjectLongClick(project: Project)
}