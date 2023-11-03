package com.project.condosa.ui.components.view.Initial

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.condosa.R
import com.project.condosa.data.remoto.ImplementacionApi.ApiPredioServiceImplementation
import com.project.condosa.domain.model.ApiResponsePredio
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeContent(email: String?, provider: String?) {
    val bluePaletColor = colorResource(id = R.color.bluePalet) // Obtener el color de color.xml

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center // Centrar horizontalmente
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow),
                            contentDescription = null,
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Emitir Recibos",
                            color = Color.White
                        )
                    }
                },
                backgroundColor = bluePaletColor // Usar el color definido en color.xml
            )
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.height(56.dp)) // 56dp es la altura de la barra azul
            }
        }
    )
}


@Composable
fun View(
    name: String,
    email: String?,
    provider: String?,
    modifier: Modifier = Modifier,

    ) {
    val iconResourceIdHome: Int = R.drawable.home  // Asigna el valor correcto del recurso de icono
    val iconResourceIdCalendar: Int =
        R.drawable.calenderio  // Asigna el valor correcto del recurso de icono


    val bluePaletColor = colorResource(id = R.color.bluePalet) // Obtener el color de color.xml
    val fonPantalla = colorResource(id = R.color.fonPantalla) // Obtener el color de color.xml
    val grisPaletLet = colorResource(id = R.color.grisPaletLet) // Obtener el color de color.xml
    val redPaletCircle = colorResource(id = R.color.redPaletCircle) // Obtener el color de color.xml

    Column(
        modifier = modifier.run {
            var background = fillMaxWidth()
                .padding(top = 55.dp)
                .background(fonPantalla)
            background

        }
    ) {
        Column(modifier = Modifier
            .padding(8.dp)
            .padding(start = 45.dp)) {
            Text(
                text = "Bienvenido",
                fontSize = 30.sp,
                modifier = Modifier.padding(bottom = 8.dp),
                color = bluePaletColor,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )

            email?.let {
                Text(
                    text = "Email: $it",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(bottom = 4.dp),
                    color= grisPaletLet
                )
            }
            /*
            provider?.let {
                Text(
                    text = "Provider: $it",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }*/
        }

        Spacer(modifier = Modifier.weight(0.5f))

        IconWithComboBox(predioText = "PREDIO",padding=50.dp,condicion = false,iconResourceIdHome)

        Spacer(modifier = Modifier.weight(0.2f))

        IconWithComboBox(predioText = "PERIODO CUOTA",padding=7.dp,condicion = true,iconResourceIdCalendar)

        Spacer(modifier = Modifier.weight(1f))

        showData()

        Spacer(modifier = Modifier.weight(1f))

        // Quinta fila con un botón centrado
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(72.dp)
                    .padding(8.dp)
                    .background(bluePaletColor, shape = RoundedCornerShape(10)) // Establece el color de fondo del Box a bluePaletColor
            ) {
                Text("Ver datos", color = Color.White,
                    style = TextStyle(fontWeight = FontWeight.Bold,
                        fontSize = 16.sp // Establece el tamaño del texto a 18 sp
                    ),
                ) // Mantiene el color del texto en blanco
            }
        }
        // Sexta fila con dos elementos Box que ocupan el mismo espacio
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .height(100.dp)
                    .weight(0.5f)
            ) {
                Box(
                    modifier = Modifier
                        .weight(2f) // Peso del 66.67% (2/3)
                        .fillMaxWidth()
                        .fillMaxHeight() // Ocupa toda la altura del Column
                        .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 0.dp)
                        .background(bluePaletColor, shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Registrar gastos del predio",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        style = TextStyle(fontWeight = FontWeight.Bold,
                            fontSize = 16.sp // Establece el tamaño del texto a 18 sp
                        ),

                        )
                }

                Box(
                    modifier = Modifier
                        .weight(1f) // Peso del 33.33% (1/3)
                        .fillMaxWidth() // Ocupa todo el ancho del Column
                        .padding(start = 8.dp, end = 8.dp, top = 0.dp, bottom = 8.dp)
                        .background(grisPaletLet), // Cambia el color si es necesario
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Segundo botón",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = TextStyle(fontWeight = FontWeight.Bold,
                                fontSize = 16.sp // Establece el tamaño del texto a 18 sp
                            ),

                            )

                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.circle),
                            contentDescription = "Icono Flecha",
                            modifier = Modifier.padding(start = 5.dp),
                            tint = redPaletCircle

                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .height(100.dp)
                    .weight(0.5f)
            ) {
                Box(
                    modifier = Modifier
                        .weight(2f) // Peso del 66.67% (2/3)
                        .fillMaxWidth()
                        .fillMaxHeight() // Ocupa toda la altura del Column
                        .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 0.dp)
                        .background(bluePaletColor, shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Registrar gastos de la casa",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        style = TextStyle(fontWeight = FontWeight.Bold,
                            fontSize = 16.sp // Establece el tamaño del texto a 18 sp
                        ),

                        )
                }

                Box(
                    modifier = Modifier
                        .weight(1f) // Peso del 33.33% (1/3)
                        .fillMaxWidth() // Ocupa todo el ancho del Column
                        .padding(start = 8.dp, end = 8.dp, top = 0.dp, bottom = 8.dp)
                        .background(grisPaletLet), // Cambia el color si es necesario
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Segundo botón",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = TextStyle(fontWeight = FontWeight.Bold,
                                fontSize = 16.sp // Establece el tamaño del texto a 18 sp
                            ),

                            )

                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.circle),
                            contentDescription = "Icono Flecha",
                            modifier = Modifier.padding(start = 5.dp),
                            tint = redPaletCircle

                        )
                    }

                }
            }



        }
    }
}




@Composable
fun showData(elemento: String = "-") {
    val bluePaletColorLet = colorResource(id = R.color.bluePaletLet) // Obtener el color de color.xml
    val grisPaletLet = colorResource(id = R.color.grisPaletLet) // Obtener el color de color.xml

    // Row para centrar horizontalmente
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        // Una sola Column para las dos filas
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Centra horizontalmente los elementos
        ) {
            // Tercera fila con dos textos "casas"
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                horizontalArrangement = Arrangement.SpaceAround // Espacio entre los textos

            ) {
                Text(
                    text = "Responsable",
                    fontSize = 18.sp,
                    color = bluePaletColorLet,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                )
                Text(
                    text = "Nº Casas",
                    fontSize = 18.sp,
                    color = bluePaletColorLet,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            }

            // Cuarta fila con dos elementos Text
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround // Espacio entre los textos
            ) {
                Text(elemento, fontSize = 18.sp)
                Text(elemento, fontSize = 18.sp)
            }
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 30.dp,end=190.dp),
                horizontalArrangement = Arrangement.Center // Espacio entre los textos
            ) {
                Text("Cargo", fontSize = 18.sp,
                    color= grisPaletLet,
                    style = TextStyle(fontStyle = FontStyle.Italic)
                )
            }
        }
    }
}



@Composable
fun IconWithComboBox(predioText: String, padding: Dp, condicion:Boolean, iconId: Int,
) {
    var expanded by remember { mutableStateOf(false) }

    var prediosResponse: ApiResponsePredio? by remember { mutableStateOf(null) }
    val apiService = ApiPredioServiceImplementation()

    LaunchedEffect(Unit) {
        try {
            val response = apiService.getPredios()
            prediosResponse = response
        } catch (e: Exception) {
            // Manejar errores, por ejemplo, mostrar un mensaje de error
        }
    }

    val options = if (prediosResponse != null) {
        listOf("Opción 1", "Opción 2","Opción 3", "Opción 4", "Opción 5",)
    } else {
        listOf("Opción 1", "Opción 2", "Opción 3")
    }

    var selectedOption by remember { mutableStateOf("Select an option") }

    val iconVector = ImageVector.vectorResource(id = iconId)
    val dropdownOffset = DpOffset(145.dp, 18.dp) // Ajusta la posición vertical del menú desplegable
    val bluePaletColor = colorResource(id = R.color.bluePalet) // Obtener el color de color.xml

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = predioText,
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = if (condicion) {
                    Modifier.padding(start = padding)
                } else {
                    Modifier.padding(end = padding)
                }
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            Color(android.graphics.Color.parseColor("#eeeff4")),
                            shape = RoundedCornerShape(30)
                        )
                        .size(60.dp) // Aumenta el tamaño del icono "Home"
                        .clickable { expanded = true }
                        .padding(2.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = iconVector,
                        contentDescription = "Icono Home",
                        tint = bluePaletColor,
                        modifier = Modifier.size(55.dp) // Establece el tamaño del icono

                    )
                }
                Spacer(modifier = Modifier.width(35.dp)) // Aumenta el espacio entre el icono y los elementos a la derecha

                Box(
                    modifier = Modifier.clickable { expanded = true },
                    contentAlignment = Alignment.CenterStart
                ) {
                    Column(
                        modifier = Modifier.padding(top = 20.dp) // Establece el padding en la parte superior (16.dp en este ejemplo)
                    ){
                        Row(
                            modifier = Modifier.width(200.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween

                        ) {
                            Text(text = selectedOption,
                                modifier = Modifier.padding(start = 1.dp),
                                style = TextStyle(fontStyle = FontStyle.Italic)
                            )
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.arrow_bottom),
                                contentDescription = "Icono Flecha",
                                modifier = Modifier.padding(start = 4.dp)) // Ajusta el espaciado a tu preferencia
                        }
                        Row(
                            modifier = Modifier
                                .width(195.dp)
                                .padding(top = 3.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Divider(
                                color = Color.Black, // Color del divider
                                thickness = 1.dp,     // Grosor del divider
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp) // Establece la altura deseada al Divider
                            )
                        }
                    }
                }
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = dropdownOffset
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        selectedOption = option
                        expanded = false
                    }
                ) {
                    Text(option)
                }
            }
        }
    }
}

