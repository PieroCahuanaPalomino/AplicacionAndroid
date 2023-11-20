package com.project.condosa.ui.components.view.GastoPredio

import ImplementacionAPI.APIGastoPredioImplementacion
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import model.GastoPredio
import model.TipoGastoPredio

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
        Box (modifier= Modifier
            .padding(horizontal = 10.dp)
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

                        items(20) { tipoGasto  ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 4.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,

                                ) {
                                Text(
                                    text = "Gasto",
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,

            ) {
            //Boton para añadir gastos
            Button(
                onClick = { /* Acciones */ },
                contentPadding = PaddingValues(horizontal = 9.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF000080)),
                modifier = Modifier.padding(top = 8.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Filled.AddCircle, contentDescription = "Agregar Gastos")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Añadir gasto", color = Color.White,fontFamily = poppins,)
                }
            }

            // Botón de Descargar
            Button(
                onClick = {
                    /* Acción para descargar */
                },
                contentPadding = PaddingValues(all = 2.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.padding(8.dp),
                content = {
                    Icon(
                        //imageVector = painterResource(id = R.drawable.download_24px),
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Descargar",
                        tint = Color(0xFF000080) // Color azul
                    )
                }
            )

            // Botón de Compartir
            Button(
                onClick = {
                    /* Acción para descargar */
                },
                contentPadding = PaddingValues(all = 2.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.padding(8.dp),
                content = {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Compartir",
                        tint = Color(0xFF000080) // Color azul
                    )
                }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Botón "Cancelar"
            Button(
                onClick = { /* Acciones */ },
                contentPadding = PaddingValues(horizontal = 35.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF000080)),
                //modifier = Modifier.padding(top = 8.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Cancelar", color = Color.White,fontFamily = poppins,)
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Botón "Finalizar Registros"
            Button(
                onClick = { /* Acciones */ },
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF000080)),
                //modifier = Modifier.padding(top = 8.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Finalizar Registros", color = Color.White,fontFamily = poppins,)
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