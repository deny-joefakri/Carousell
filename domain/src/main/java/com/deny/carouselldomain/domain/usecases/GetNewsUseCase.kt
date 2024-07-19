package com.deny.carouselldomain.domain.usecases

import com.deny.carouselldomain.domain.models.NewsModel
import com.deny.carouselldomain.domain.repositories.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(private val repository: Repository) {
    operator fun invoke(): Flow<List<NewsModel>> {
        return repository.getNews()
    }
}
