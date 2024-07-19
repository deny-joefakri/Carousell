package com.deny.carouselldomain.domain.test

import com.deny.carouselldomain.domain.models.NewsModel


object MockUtil {

    val news = listOf(
        NewsModel(
            id = "",
            title = "name1",
            description = "name1",
            bannerUrl = "name1",
            timeCreated = 12334,
            rank = 2,
        )
    )
}
