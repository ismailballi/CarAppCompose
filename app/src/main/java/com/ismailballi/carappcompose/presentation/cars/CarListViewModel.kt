package com.ismailballi.carappcompose.presentation.cars

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ismailballi.carappcompose.domain.usecase.CarUseCase
import com.ismailballi.carappcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CarListViewModel @Inject constructor(val carUseCase: CarUseCase) : ViewModel() {


    private val _state = mutableStateOf(CarState())
    val state = _state


    init {
        getCarList()
    }

    fun getCarList() {
        carUseCase.getCarList().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = CarState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = CarState(carList = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = CarState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }

}