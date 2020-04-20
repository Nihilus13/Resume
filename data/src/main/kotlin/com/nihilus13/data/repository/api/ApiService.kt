package com.nihilus13.data.repository.api

import com.nihilus13.domain.model.Resume
import retrofit2.http.GET

interface ApiService {
    @GET("master/data/src/test/kotlin/com/nihilus13/data/repository/datamock.json")
    suspend fun fetchResume(): Resume
}