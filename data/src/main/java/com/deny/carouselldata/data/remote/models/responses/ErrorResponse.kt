package com.deny.carouselldata.data.remote.models.responses

import com.deny.carouselldomain.domain.models.Error
import com.squareup.moshi.Json

data class ErrorResponse(
    @Json(name = "message")
    val message: String
)

internal fun ErrorResponse.toModel() = Error(message = message)
