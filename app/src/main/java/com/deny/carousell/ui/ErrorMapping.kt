package com.deny.carousell.ui

import android.content.Context
import com.deny.carousell.R
import com.deny.carouselldomain.domain.exceptions.ApiException
import com.deny.carousell.extensions.showToast

fun Throwable.userReadableMessage(context: Context): String {
    return when (this) {
        is ApiException -> error?.message
        else -> message
    } ?: context.getString(R.string.error_generic)
}

fun Throwable.showToast(context: Context) =
    context.showToast(userReadableMessage(context))
