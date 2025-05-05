package com.ismailballi.carappcompose.data.api

import com.ismailballi.carappcompose.data.model.CarDto
import retrofit2.http.GET

interface CarApi {

    @GET("ismailballi/SampleData/refs/heads/develop/car.json")
    suspend fun getCars(): List<CarDto>
}