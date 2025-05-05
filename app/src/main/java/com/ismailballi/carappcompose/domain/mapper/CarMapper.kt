package com.ismailballi.carappcompose.domain.mapper

import com.ismailballi.carappcompose.data.model.CarDto
import com.ismailballi.carappcompose.domain.model.Car


fun CarDto.toCar(): Car {
    return Car(logo = logo, name = name)

}