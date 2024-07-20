package com.deny.carousell.ui.models

import android.os.Parcelable
import com.deny.carouselldomain.domain.models.NewsModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class UiNewsModel(
    val id: String,
    val title: String,
    val description: String,
    val bannerUrl: String,
    val timeCreated: Int,
    val rank: Int,
) : Parcelable

fun NewsModel.toUiNewsModel() = UiNewsModel(
    id.toString(),
    title.orEmpty(),
    description.orEmpty(),
    bannerUrl.orEmpty(),
    timeCreated ?: 0,
    rank ?: 0,
)
