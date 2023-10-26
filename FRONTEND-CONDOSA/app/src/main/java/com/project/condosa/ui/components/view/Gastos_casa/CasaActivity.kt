package com.project.condosa.ui.components.view.Gastos_casa

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
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


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")

@Composable
fun GastosContent(email: String?, provider: String?) {
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
                Spacer(modifier = Modifier.height(20.dp)) // 56dp es la altura de la barra azul
            }
        }
    )
}



@Composable
fun ViewGastos(
    name: String,
    email: String?,
    provider: String?,
    modifier: Modifier = Modifier,

    ) {
    val iconResourceNCasa: Int =
        R.drawable.gastos_casas_vector1  // Asigna el valor correcto del recurso de icono

    val bluePaletColor = colorResource(id = R.color.bluePalet) // Obtener el color de color.xml
    val fonPantalla = colorResource(id = R.color.fonPantalla) // Obtener el color de color.xml
    val grisPaletLet = colorResource(id = R.color.grisPaletLet) // Obtener el color de color.xml

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
                text = "Lomas Tingo",
                fontSize = 20.sp,
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

        }

        //Spacer(modifier = Modifier.weight(0.5f))

        GastosIconComboBox(predioText = "No de Casa",padding=50.dp,condicion = false,iconResourceNCasa)

        Spacer(modifier = Modifier.weight(0.2f))

        MostrarDataGastos()

        //Spacer(modifier = Modifier.weight(1f))

        muestraGastos()

        Spacer(modifier = Modifier.weight(0.5f))
        botonesAuxiliares()
        //Spacer(modifier = Modifier.weight(0.2f))


        // Quinta fila con dos elementos Box que ocupan el mismo espacio
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
                        .width(150.dp)
                        .height(80.dp) // Ocupa toda la altura del Column
                        .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 0.dp)
                        .background(bluePaletColor, shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Cancelar",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        style = TextStyle(fontWeight = FontWeight.Bold,
                            fontSize = 20.sp // Establece el tamaño del texto a 18 sp
                        ),

                        )
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
                        .width(150.dp)
                        .height(80.dp)
                        .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 0.dp)
                        .background(bluePaletColor, shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Finalizar Registro",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        style = TextStyle(fontWeight = FontWeight.Bold,
                            fontSize = 20.sp // Establece el tamaño del texto a 18 sp
                        ),

                        )
                }
            }



        }
    }
}


@Composable
fun MostrarDataGastos(elemento: String = "-") {
    val bluePaletColorLet = colorResource(id = R.color.bluePaletLet) // Obtener el color de color.xml
    val bluePaletColor = colorResource(id = R.color.bluePalet) // Obtener el color de color.xml

    // Row para centrar horizontalmente
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Propietario",
                fontSize = 18.sp,
                color = bluePaletColorLet,
                style = TextStyle(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )
            Text(elemento, fontSize = 18.sp, textAlign = TextAlign.Center)
        }

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Estado",
                fontSize = 18.sp,
                color = bluePaletColorLet,
                style = TextStyle(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )
            Text(elemento, fontSize = 18.sp, textAlign = TextAlign.Center)
        }

        Box(
            modifier = Modifier
                .width(100.dp)
                .height(80.dp)
                .background(bluePaletColor, shape = RoundedCornerShape(10)),
            contentAlignment = Alignment.Center
        ) {
            Text("Ver datos", color = Color.White, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp))
        }
    }
}


@Composable
fun muestraGastos(elemento: String = "Texto"){

    val iconResourceEditar: Int =
        R.drawable.gastos_casas_vector6  // Asigna el valor correcto del recurso de icono
    val bluePaletColorLet = colorResource(id = R.color.bluePaletLet) // Obtener el color de color.xml

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
                    text = "Gasto",
                    fontSize = 18.sp,
                    color = bluePaletColorLet,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                )
                Text(
                    text = "Monto(s/)",
                    fontSize = 18.sp,
                    color = bluePaletColorLet,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = " ",
                    fontSize = 18.sp,
                    color = bluePaletColorLet,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            }

            repeat(7) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround // Espacio entre los textos
                ) {
                    Text("Texto", fontSize = 18.sp)
                    Text("Texto", fontSize = 18.sp)
                    Icon(
                        painter = painterResource(id = iconResourceEditar),
                        contentDescription = "Icono",
                        tint = bluePaletColorLet,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun botonesAuxiliares() {
    val iconResourceAgregarGastos: Int = R.drawable.gastos_casas_vector2
    val iconResourceDownload: Int = R.drawable.gastos_casas_vector4
    val iconResourceCompartir: Int = R.drawable.gastos_casas_vector5
    val bluePaletColor = colorResource(id = R.color.bluePalet) // Obtener el color de color.xml
    val whitePaletColor = colorResource(id = R.color.fonPantalla)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(bottom = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Botón Agregar Gastos
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(90.dp)
                .background(bluePaletColor, shape = RoundedCornerShape(10))
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = iconResourceAgregarGastos),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(55.dp)
                )
                Text("Añadir Gastos", color = Color.White, style = TextStyle(fontWeight = FontWeight.Bold))
            }
        }

        // Botón Descargar
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(70.dp)
                .background(whitePaletColor, shape = RoundedCornerShape(10))
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = iconResourceDownload),
                    contentDescription = null,
                    tint = Color.Blue,
                    modifier = Modifier.size(55.dp)
                )
                Text("Descargar", color = Color.White, style = TextStyle(fontWeight = FontWeight.Bold))
            }
        }

        // Botón Compartir
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(70.dp)
                .background(whitePaletColor, shape = RoundedCornerShape(10))
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = iconResourceCompartir),
                    contentDescription = null,
                    tint = Color.Blue,
                    modifier = Modifier.size(55.dp)
                )
                Text("Compartir", color = Color.White, style = TextStyle(fontWeight = FontWeight.Bold))
            }
        }
    }
}

@Composable
fun GastosIconComboBox(predioText: String, padding: Dp, condicion:Boolean, iconId: Int,
) {

    var expanded by remember { mutableStateOf(false) }
    val options = listOf("1", "2", "3","4","5","6","7","8","9","10","11","12")
    var selectedOption by remember { mutableStateOf("Selecciona la cantidad") }

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