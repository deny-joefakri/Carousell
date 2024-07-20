package com.deny.carouselldata.data.repositories

import com.deny.carouselldata.data.extensions.flowTransform
import com.deny.carouselldata.data.remote.models.responses.toModels
import com.deny.carouselldata.data.remote.services.ApiService
import com.deny.carouselldomain.domain.models.NewsModel
import com.deny.carouselldomain.domain.repositories.Repository
import kotlinx.coroutines.flow.Flow

class RepositoryImpl constructor(
    private val apiService: ApiService
) : Repository {
    override fun getNews(): Flow<List<NewsModel>> = flowTransform {
        apiService.getResponses().toModels()
    }
}
