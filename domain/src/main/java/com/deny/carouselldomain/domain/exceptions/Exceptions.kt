package com.deny.carouselldomain.domain.exceptions

import com.deny.carouselldomain.domain.models.Error

object NoConnectivityException : RuntimeException()

data class ApiException(
    val error: Error?,
    val httpCode: Int,
    val httpMessage: String?
) : RuntimeException()
