package com.deny.carousell.test

import com.deny.carouselldomain.domain.models.NewsModel


object MockUtil {

    val models = listOf(
        NewsModel(
            id = "1",
            title = "name1",
            description = "name1",
            bannerUrl = "name1",
            timeCreated = 1,
            rank = 1,
        ),
        NewsModel(
            id = "2",
            title = "name2",
            description = "name2",
            bannerUrl = "name2",
            timeCreated = 2,
            rank = 2,
        ),
        NewsModel(
            id = "3",
            title = "name3",
            description = "name3",
            bannerUrl = "name3",
            timeCreated = 3,
            rank = 3,
        ),
    )
}
