package com.deny.carouselldata.data.remote.providers

import com.deny.carouselldata.data.remote.services.ApiService
import retrofit2.Retrofit

object ApiServiceProvider {

    fun getApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}
