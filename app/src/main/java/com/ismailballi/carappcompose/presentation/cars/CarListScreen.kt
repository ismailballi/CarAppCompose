package com.ismailballi.carappcompose.presentation.cars

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ismailballi.carappcompose.presentation.cars.component.CarListRow

@Composable
fun CarListScreen(viewModel: CarListViewModel = hiltViewModel<CarListViewModel>()) {


    val state by remember { viewModel.state }

    Column(
        Modifier
            .verticalScroll(state = rememberScrollState())
    ) {
        state.carList.forEach {
            CarListRow(it)
        }
    }
    if (state.isLoading) {
        CircularProgressIndicator(
            modifier = Modifier.size(25.dp),
            strokeWidth = 3.dp,
            color = Color.Gray
        )
    }
    if (state.error.isNotEmpty()) {
        Text(text = state.error, color = Color.Gray)
    }


}