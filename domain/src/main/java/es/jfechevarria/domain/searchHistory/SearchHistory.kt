package es.jfechevarria.domain.searchHistory

import es.jfechevarria.domain.common.DomainValueObject

data class SearchHistory(
    val query: String,
    val createdOn: Long
    ): DomainValueObject()