package com.ismailballi.carappcompose.presentation.cars

import com.ismailballi.carappcompose.domain.model.Car

data class CarState(
    val isLoading: Boolean = false,
    val carList: List<Car> = emptyList<Car>(),
    val error: String = "",
)