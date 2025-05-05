package com.ismailballi.carappcompose.domain.usecase

import com.ismailballi.carappcompose.domain.mapper.toCar
import com.ismailballi.carappcompose.domain.model.Car
import com.ismailballi.carappcompose.domain.repository.CarRepository
import com.ismailballi.carappcompose.util.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CarUseCase @Inject constructor(val repository: CarRepository) {

    fun getCarList() = flow<Resource<List<Car>>> {
        try {
            emit(Resource.Loading())
            val cars = repository.getCars()
            if (cars.isNotEmpty()) {
                emit(Resource.Success(data = cars.map { it.toCar() }))
            } else {
                emit(Resource.Error("Data is null"))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage))
        }


    }

}