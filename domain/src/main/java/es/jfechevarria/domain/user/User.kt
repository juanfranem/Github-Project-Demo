package es.jfechevarria.domain.user

import es.jfechevarria.domain.common.DomainValueObject

data class User(
    val image: String,
    val userName: String,
    val externalUrl: String
): DomainValueObject()