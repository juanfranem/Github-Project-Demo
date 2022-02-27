package es.jfechevarria.github_sdk.common

import kotlinx.serialization.Serializable

@Serializable
internal abstract class BaseResponseList<T>: BaseResponse(), List<T>