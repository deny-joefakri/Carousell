package com.deny.carouselldomain.domain.repositories

import com.deny.carouselldomain.domain.models.NewsModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getNews(): Flow<List<NewsModel>>
}
