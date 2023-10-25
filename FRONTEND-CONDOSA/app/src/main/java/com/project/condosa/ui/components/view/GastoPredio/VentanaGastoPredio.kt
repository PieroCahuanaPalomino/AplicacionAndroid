package com.project.condosa.ui.components.view.GastoPredio

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.google.relay.compose.RelayContainer

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GastosPredio(
    modifier: Modifier = Modifier,
    name: String, period: String
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Encabezado de la aplicación
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF000080))
        ) {
            Text(
                text = "Gasto del Predio",
                fontSize = 20.sp,
                fontFamily = poppins,
                color = Color.White,
                modifier = Modifier.padding(start = 27.dp, top = 24.dp, bottom = 20.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 27.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = name,
                fontSize = 16.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.Bold,
                color = Color(
                    alpha = 255,
                    red = 0,
                    green = 0,
                    blue = 0
                )
            )
            Text(
                text = period,
                fontSize = 16.sp,
                fontFamily = poppins,
                color = Color(0XFF8A8B8D),
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
private fun GastosPredioPreview() {
    MaterialTheme {
        GastosPredio(name="Los Rosales", period = "2023-I")
    }
}