package com.project.condosa.ui.components.view.GastoPredio

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

        // Tabla de gastos (LazyColumn)
        Box (modifier=Modifier.padding(horizontal = 10.dp)
            .clip(RoundedCornerShape(4))){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(width = 400.dp, height = 340.dp)
                    .background(Color(0xFFFFFFFF))
                    .padding(vertical = 8.dp))
            {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFF000080))
                            .clip(RoundedCornerShape(0.dp, 0.dp, 8.dp, 8.dp))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Gasto",
                                fontSize = 16.sp,
                                fontFamily = poppins,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.weight(2.5f)
                            )
                            Text(
                                text = "Monto (S/)",
                                fontSize = 16.sp,
                                fontFamily = poppins,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.weight(1.5f)
                            )
                            Text(
                                text = "",
                                fontSize = 16.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.weight(0.5f)
                            )
                        }
                    }
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .width(400.dp) // Establece el ancho deseado para la tabla
                            .background(Color(0xFFF6F8FF)) // Color de fondo de la tabla
                        // contentPadding = PaddingValues(horizontal = 14.dp)
                    ) {
                        items(20) { index ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 4.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,

                                ) {
                                Text(
                                    text = "Gasto ${index + 1}",
                                    fontSize = 15.sp,
                                    fontFamily = poppins,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier.weight(2f)
                                )
                                Text(
                                    text = "S/100.00",
                                    fontSize = 15.sp,
                                    fontFamily = poppins,
                                    modifier = Modifier.weight(1.5f)
                                )
                                Icon(
                                    imageVector = Icons.Default.Edit,
                                    contentDescription = "Editar",
                                    tint = Color(0xFF000080)
                                )
                            }
                        }
                    }
                }

            }
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