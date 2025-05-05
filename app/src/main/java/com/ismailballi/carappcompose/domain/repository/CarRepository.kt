package com.ismailballi.carappcompose.domain.repository

import com.ismailballi.carappcompose.data.api.CarApi
import com.ismailballi.carappcompose.data.model.CarDto
import com.ismailballi.carappcompose.data.repository.CarRepositoryImpl
import javax.inject.Inject

class CarRepository @Inject constructor(val carApi: CarApi): CarRepositoryImpl {

    override suspend fun getCars(): List<CarDto> {
        return carApi.getCars()
    }

}