package com.deny.carouselldata.data.remote.models.responses

import com.deny.carouselldomain.domain.models.NewsModel
import com.squareup.moshi.Json

data class NewsResponse(
    @Json(name = "id")
    val id: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "banner_url")
    val bannerUrl: String?,
    @Json(name = "time_created")
    val timeCreated: Int?,
    @Json(name = "rank")
    val rank: Int?,
)

private fun NewsResponse.toModel() = NewsModel(
    id = this.id,
    title = this.title,
    description = this.description,
    bannerUrl = this.bannerUrl,
    timeCreated = this.timeCreated,
    rank = this.rank,
)

fun List<NewsResponse>.toModels() = this.map { it.toModel() }
