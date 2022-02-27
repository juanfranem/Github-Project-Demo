package es.jfechevarria.domain.project

import es.jfechevarria.domain.common.DomainValueObject

data class Project(
    val name: String,
    val private: Boolean,
    val externalUrl: String,
    val description: String,
    val forked: Boolean,
    val forksCount: Int,
    val createdDate: String,
    val updatedDate: String,
    val language: String,
): DomainValueObject()