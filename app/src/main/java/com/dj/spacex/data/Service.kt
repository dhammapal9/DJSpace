package com.dj.spacex.data

import com.dj.spacex.data.rocket.model.Rocket
import retrofit2.Response
import retrofit2.http.GET

interface Service {



    @GET("v4/rockets")
    suspend fun getRockets(): Response<List<Rocket>>


}