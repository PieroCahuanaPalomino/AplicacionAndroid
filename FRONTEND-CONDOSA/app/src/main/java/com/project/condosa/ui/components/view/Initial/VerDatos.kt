package com.project.condosa.ui.components.view.Initial

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.project.condosa.ui.components.view.GastoPredio.poppins

@Composable
fun VerDatos(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F8FF))
    ) {
        // Encabezado de la aplicación
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF000080))
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 27.dp, top = 20.dp, bottom = 20.dp)
            ) {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Boton Atras",
                    tint = Color.White,
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
                Text(
                    text = "Datos casas",
                    fontSize = 20.sp,
                    fontFamily = poppins,
                    color = Color.White,
                    modifier = Modifier.padding(start = 15.dp)
                )
            }
        }
        // Fin Encabezado
        Row {
            Text(text = "Venatana ver datos abierta")
        }
    }
}