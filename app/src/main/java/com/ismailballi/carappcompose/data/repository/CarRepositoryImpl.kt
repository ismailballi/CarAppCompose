package com.ismailballi.carappcompose.data.repository

import com.ismailballi.carappcompose.data.model.CarDto

interface CarRepositoryImpl {

    suspend fun getCars(): List<CarDto>
}