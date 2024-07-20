package com.deny.carouselldata.data.remote.services

import com.deny.carouselldata.data.remote.models.responses.NewsResponse
import retrofit2.http.GET

interface ApiService {

    @GET("carousell_news.json")
    suspend fun getResponses(): List<NewsResponse>
}
