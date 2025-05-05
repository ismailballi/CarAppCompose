package com.ismailballi.carappcompose.presentation.cars.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.ismailballi.carappcompose.domain.model.Car

@Composable
fun CarListRow(car: Car) {

    Row {
        Image(
            painter = rememberAsyncImagePainter(car.logo),
            contentDescription = car.name,
            modifier = Modifier
                .size(40.dp)
                .padding(5.dp)
        )
        Text(
            text = car.name,
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
                .fillMaxWidth()
        )
    }
}