package com.project.condosa.ui.components.view.Gastos_casa

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.project.condosa.ui.components.view.GastoPredio.poppins
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.net.URL

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")

@kotlinx.serialization.Serializable
data class CasaData(
    val casas: List<Casa>,
    val message: String,
    val success: Boolean
)

@kotlinx.serialization.Serializable
data class Casa(
    val area_casa: String,
    val area_cochera: String,
    val area_total: String,
    val estado: String,
    val id_casa: Int,
    val id_indice: Int,
    val id_predio: Int,
    val mdu: String,
    val numero: Int,
    val participacion: String,
    val piso: Int,
    val responsable: String
)

// Función para obtener datos de la API
suspend fun fetchDataFromAPI(numeroPredio: Int): CasaData {
    return withContext(Dispatchers.IO) {
        val url = URL("http://127.0.0.1:5000/getPredios/5/getCasas")
        val jsonString = url.readText()

        // Deserializa la respuesta JSON
        return@withContext Json.decodeFromString(jsonString)
    }
}

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
    var responsable by remember { mutableStateOf("") }
    var loading by remember { mutableStateOf(true) }

    val scope = rememberCoroutineScope()
    // Llamada a la API para obtener los datos del responsable
    LaunchedEffect(Unit) {
        val result = fetchDataFromAPI(14) // Aquí se debe pasar el número de predio correcto
        loading = false
        responsable = result.casas.firstOrNull()?.responsable ?: ""
    }
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

        MostrarDataGastos(responsable)

        //Spacer(modifier = Modifier.weight(1f))

        muestraGastos()

        Spacer(modifier = Modifier.weight(0.5f))
        botonesAuxiliares()
        //Spacer(modifier = Modifier.weight(0.2f))


        // Quinta fila con dos elementos Box que ocupan el mismo espacio
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { /* Acciones */ },
                contentPadding = PaddingValues(horizontal = 35.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF000080)),
                //modifier = Modifier.padding(top = 8.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    androidx.compose.material3.Text(
                        "Cancelar",
                        color = Color.White,
                        fontFamily = poppins,
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { /* Acciones */ },
                contentPadding = PaddingValues(horizontal = 35.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF000080)),
                //modifier = Modifier.padding(top = 8.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    androidx.compose.material3.Text(
                        "Finalizar registro",
                        color = Color.White,
                        fontFamily = poppins,
                    )
                }
            }



        }
    }
}


@Composable
fun MostrarDataGastos(nom_prop: String) {
    val bluePaletColorLet = colorResource(id = R.color.bluePaletLet) // Obtener el color de color.xml
    val bluePaletColor = colorResource(id = R.color.bluePalet) // Obtener el color de color.xml

    // Row para centrar horizontalmente
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 15.dp),
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
            Text("Quintana Fabrizzio", fontSize = 18.sp, textAlign = TextAlign.Center)
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
            Text("Activo", fontSize = 18.sp, textAlign = TextAlign.Center)
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
fun muestraGastos(){

    val iconResourceEditar: Int =
        R.drawable.gastos_casas_vector6  // Asigna el valor correcto del recurso de icono
    val bluePaletColorLet = colorResource(id = R.color.bluePaletLet) // Obtener el color de color.xml

    // Tabla Gastos de Casa perteneciente a Predio
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
                        androidx.compose.material3.Text(
                            text = "Gasto",
                            fontSize = 16.sp,
                            fontFamily = poppins,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(2.5f)
                        )
                        androidx.compose.material3.Text(
                            text = "Monto (S/)",
                            fontSize = 16.sp,
                            fontFamily = poppins,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(1.5f)
                        )
                        androidx.compose.material3.Text(
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
                            androidx.compose.material3.Text(
                                text = "Casa_gasto ${index + 1}",
                                fontSize = 15.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.Normal,
                                modifier = Modifier.weight(2f)
                            )
                            androidx.compose.material3.Text(
                                text = "S/2000.00",
                                fontSize = 15.sp,
                                fontFamily = poppins,
                                modifier = Modifier.weight(1.5f)
                            )
                            androidx.compose.material3.Icon(
                                ImageVector.vectorResource(id = iconResourceEditar),
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
            .padding(horizontal = 20.dp, vertical = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        //Boton agregar gastos
        Button(
            onClick = { /* Acciones */ },
            contentPadding = PaddingValues(horizontal = 9.dp, vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF000080)),
            modifier = Modifier.padding(top = 8.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                androidx.compose.material3.Icon(
                    imageVector = ImageVector.vectorResource(id = iconResourceAgregarGastos),
                    contentDescription = "Agregar Gastos"
                )
                Spacer(modifier = Modifier.width(8.dp))
                androidx.compose.material3.Text(
                    "Añadir gasto",
                    color = Color.White,
                    fontFamily = poppins,
                )
            }
        }

        // Botón Descargar
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(70.dp)
                .background(whitePaletColor, shape = RoundedCornerShape(10))
        ) {
            Button(
                onClick = {
                    /* Acción para descargar */
                },
                contentPadding = PaddingValues(all = 2.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.padding(8.dp),
                content = {
                    androidx.compose.material3.Icon(
                        //imageVector = painterResource(id = R.drawable.download_24px),
                        imageVector = ImageVector.vectorResource(id = iconResourceDownload),
                        contentDescription = "Descargar",
                        tint = Color(0xFF000080) // Color azul
                    )
                }
            )
        }

        // Botón Compartir
        Button(
            onClick = {
                /* Acción para descargar */
            },
            contentPadding = PaddingValues(all = 2.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(8.dp),
            content = {
                androidx.compose.material3.Icon(
                    //imageVector = painterResource(id = R.drawable.download_24px),
                    imageVector = ImageVector.vectorResource(id = iconResourceCompartir),
                    contentDescription = "Compartir",
                    tint = Color(0xFF000080) // Color azul
                )
            }
        )
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