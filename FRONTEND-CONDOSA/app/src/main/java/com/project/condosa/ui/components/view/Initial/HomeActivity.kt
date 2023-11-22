package com.project.condosa.ui.components.view.Initial

import android.annotation.SuppressLint
import android.widget.RadioGroup
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.lifecycleScope
import com.google.relay.compose.RowScopeInstanceImpl.align
import com.project.condosa.R
import com.project.condosa.data.remoto.ImplementacionApi.ApiPredioServiceImplementation
import com.project.condosa.domain.model.ApiResponsePredio
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.Response
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.lifecycleScope
import com.project.condosa.domain.model.ApiResponseCasa
import com.project.condosa.domain.model.ApiResponsePredioPeriodo
import com.project.condosa.domain.model.ApiResponsePredioSingle
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random
import com.project.condosa.ui.components.view.Initial.IconWithComboBox as IconWithComboBox


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




var globalSelectedOptionIndexPeriodo by mutableStateOf(-1)
var globalSelectedOptionIndex by mutableStateOf(-1)
var textCantidadCasas by mutableStateOf("-")
var textResponsable by mutableStateOf("-")
 @Suppress("UNUSED_VARIABLE")
 @SuppressLint("CoroutineCreationDuringComposition")
 @Composable
fun View(
    name: String,
    email: String?,
    provider: String?,
    lifecycleScope : CoroutineScope?=null,
    modifier: Modifier = Modifier
)
{
    val iconResourceIdHome: Int =
        R.drawable.home  // Asigna el valor correcto del recurso de icono
    val iconResourceIdCalendar: Int =
        R.drawable.calenderio  // Asigna el valor correcto del recurso de icono
    val bluePaletColor = colorResource(id = R.color.bluePalet) // Obtener el color de color.xml
    val fonPantalla = colorResource(id = R.color.fonPantalla) // Obtener el color de color.xml
    val grisPaletLet = colorResource(id = R.color.grisPaletLet) // Obtener el color de color.xml
    val redPaletCircle =
        colorResource(id = R.color.redPaletCircle) // Obtener el color de color.xml

    var prediosResponse: ApiResponsePredio? by remember { mutableStateOf(null) }
    val apiService = ApiPredioServiceImplementation()
    var options by remember { mutableStateOf<List<String>>(emptyList()) }
    var optionsPeriodo by remember { mutableStateOf<List<String>>(emptyList()) }
    val context = LocalContext.current
    var textNumCasas : String = "-"
    var textResponsable: String = "-"

    LaunchedEffect(Unit) {
        lifecycleScope?.launch(Dispatchers.IO) {
            try {
                val responsePredios: Response<ApiResponsePredio> = apiService.getPredios()

                val idSeleccionado = selectedOptionIndex
                val responseCasa : Response<ApiResponseCasa> =
                    apiService.getCasas(idSeleccionado)



                withContext(Dispatchers.Main) {
                    if (responsePredios.isSuccessful) {
                        val apiResponse = responsePredios.body()
                        val success = apiResponse?.success ?: false

                        options =  apiResponse?.predios!!.map { it.predio }



                        var apiResponseCasa = responseCasa.body()

                        val responsable=apiResponseCasa?.casas?.firstOrNull()?.responsable
                        val cantidadDeCasas: Int = apiResponseCasa?.casas?.size ?: 0

                        textNumCasas="PIERO"
                        textResponsable=responsable.toString()
                        // Muestra el valor de success en el Toast
                        Toast.makeText(context, "Success: $options", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            } catch (e: Exception) {
                // Manejar errores, por ejemplo, mostrar un mensaje de error en caso de excepción
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
    Column(
        modifier = modifier.run {
            var background = fillMaxWidth()
                .padding(top = 55.dp)
                .background(fonPantalla)
            background

        }
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .padding(start = 45.dp)
        ) {
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
                    color = grisPaletLet
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

        IconWithComboBox(
            predioText = "PREDIO",
            padding = 0.dp,
            condicion = false,
            iconResourceIdHome,
            options,false,
        ) {
            //openDialog = true
        }


        //(showDialog = openDialog.value, dismissDialog = {openDialog.value=false})

        Spacer(modifier = Modifier.weight(0.2f))

        IconWithComboBox(
            predioText = "PERIODO CUOTA",
            padding = 0.dp,
            condicion = true,
            iconResourceIdCalendar,
            optionsPeriodo,true,
        ) {
            //openDialog = true
        }

        //Dialog(showDialog = openDialog.value, dismissDialog = {openDialog.value=false})

        Spacer(modifier = Modifier.weight(1f))

        showData(lifecycleScope,textNumCasas)

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
                    .background(
                        bluePaletColor,
                        shape = RoundedCornerShape(10)
                    )
                    .clickable {
                        // Aquí puedes manejar el evento de clic
                        /*globalSelectedOptionIndex= Random.nextInt(1, 101)*/
                    }
            ) {
                Text(
                    "Ver datos", color = Color.White,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
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
                        .background(
                            bluePaletColor,
                            shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Registrar gastos del predio",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
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
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
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
                        .background(
                            bluePaletColor,
                            shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Registrar gastos de la casa",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
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
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
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
var selectedOptionIndex : Int= -1
var selectedOptionIndexPeriodo : Int= -1
@Composable
fun showData(
    lifecycleScope : CoroutineScope?=null,
    textNumCasas: String ,
    ) {
    val bluePaletColorLet = colorResource(id = R.color.bluePaletLet) // Obtener el color de color.xml
    val grisPaletLet = colorResource(id = R.color.grisPaletLet) // Obtener el color de color.xml
    val apiService = ApiPredioServiceImplementation()
    var responsable by remember { mutableStateOf<List<String>>(emptyList()) }
    val context = LocalContext.current
    var options by remember { mutableStateOf<List<String>>(emptyList()) }
    var selectionMade by remember { mutableStateOf(false) } // Nueva variable de estado

    if(globalSelectedOptionIndex!=-1 && globalSelectedOptionIndexPeriodo!=-1){
        LaunchedEffect(globalSelectedOptionIndex, globalSelectedOptionIndexPeriodo) {
            Toast.makeText(context, "HOLLA", Toast.LENGTH_SHORT).show()
            try {


                val idSeleccionado = globalSelectedOptionIndex+1
                val responseCasa: Response<ApiResponseCasa> =
                    apiService.getCasas(idSeleccionado)


                //val responseText: Response=
                if (responseCasa.isSuccessful) {
                    val apiResponsePeriodo = responseCasa.body()
                    val successPeriodo = apiResponsePeriodo?.success ?: false

                    var responsable = apiResponsePeriodo?.casas?.firstOrNull()?.responsable
                    val cantidadCasas: Int = apiResponsePeriodo?.casas?.size ?: 0

                    textCantidadCasas=cantidadCasas.toString()
                    textResponsable=responsable.toString()
                    //textNumCasas=cantidadCasas.toString()
                    // Muestra el valor de successPeriodo en el Toast
                    Toast.makeText(context, "Success: $globalSelectedOptionIndex", Toast.LENGTH_SHORT)
                        .show()
                }


            } catch (e: Exception) {
                // Manejar errores, por ejemplo, mostrar un mensaje de error en caso de excepción
                Toast.makeText(context, "ErrorPeriodo: ${e.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

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
                Text(textResponsable, fontSize = 18.sp)
                Text(textCantidadCasas, fontSize = 18.sp)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, end = 190.dp),
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


@OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)
@Composable
fun IconWithComboBox(
    predioText: String,
    padding: Dp,
    condicion: Boolean,
    iconId: Int,
    options: List<String>,
    periodoBoolean: Boolean,
    openDialog: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Select an option") }

    val iconVector = ImageVector.vectorResource(id = iconId)
    val bluePaletColor = colorResource(id = R.color.bluePalet)

    val apiService = ApiPredioServiceImplementation()
    var optionsPeriodo by remember { mutableStateOf<List<String>>(emptyList()) }
    val context = LocalContext.current

    if(periodoBoolean){
        LaunchedEffect(selectedOptionIndex) {
            if (/*expanded &&*/ selectedOptionIndex != -1) {
                try {


                    val idSeleccionado = selectedOptionIndex+1
                    val responsePeriodo: Response<ApiResponsePredioPeriodo> =
                        apiService.getPrediosPeriodo(idSeleccionado)


                    //val responseText: Response=
                    if (responsePeriodo.isSuccessful) {
                        val apiResponsePeriodo = responsePeriodo.body()
                        val successPeriodo = apiResponsePeriodo?.success ?: false

                        optionsPeriodo = apiResponsePeriodo?.gastos?.map { it.periodo } ?: emptyList()

                        // Muestra el valor de successPeriodo en el Toast
                        Toast.makeText(context, "Success: $optionsPeriodo", Toast.LENGTH_SHORT)
                            .show()
                    }


                } catch (e: Exception) {
                    // Manejar errores, por ejemplo, mostrar un mensaje de error en caso de excepción
                    Toast.makeText(context, "ErrorPeriodo: ${e.message}", Toast.LENGTH_SHORT)
                        .show()
                }
            }

        }
    }
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
                        .size(60.dp)
                        .clickable { expanded = true },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = iconVector,
                        contentDescription = "Icono Home",
                        tint = bluePaletColor,
                        modifier = Modifier.size(55.dp)
                    )
                }
                Spacer(modifier = Modifier.width(35.dp))

                Box(
                    modifier = Modifier.clickable { expanded = true },
                    contentAlignment = Alignment.CenterStart
                ) {
                    Column(
                        modifier = Modifier.padding(top = 20.dp)
                    ) {
                        Row(
                            modifier = Modifier.width(200.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = selectedOption,
                                modifier = Modifier.padding(start = 1.dp),
                                style = TextStyle(fontStyle = FontStyle.Italic)
                            )
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.arrow_bottom),
                                contentDescription = "Icono Flecha",
                                modifier = Modifier.padding(start = 4.dp)
                            )
                        }
                        Row(
                            modifier = Modifier
                                .width(195.dp)
                                .padding(top = 3.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Divider(
                                color = Color.Black,
                                thickness = 1.dp,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                            )
                        }
                    }
                }
            }
        }
    }

    val redPaletCircleColor = colorResource(id = R.color.redPaletCircle)

    if (expanded) {
        Dialog(
            onDismissRequest = { expanded = false },
        ) {
            Column(Modifier.background(Color.White)) {
                Text(
                    text = "Pick something from the list",
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                FlowRow(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .weight(1f)
                ) {
                    if(periodoBoolean){
                        for ((index, option) in optionsPeriodo.withIndex()) {
                            Column(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = index == selectedOptionIndexPeriodo,
                                        onClick = {
                                            // Actualiza el estado cuando se hace clic en el RadioButton
                                            selectedOption = option
                                            selectedOptionIndexPeriodo = index
                                            globalSelectedOptionIndexPeriodo = index
                                        }
                                    )

                                    Text(option, modifier = Modifier.padding(start = 8.dp))
                                }
                            }
                        }
                    }else{
                        for ((index, option) in options.withIndex()) {
                            Column(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = index == selectedOptionIndex,
                                        onClick = {
                                            // Actualiza el estado cuando se hace clic en el RadioButton
                                            selectedOption = option
                                            selectedOptionIndex = index
                                            globalSelectedOptionIndex = index
                                        }
                                    )
                                    Text(option, modifier = Modifier.padding(start = 8.dp))
                                }
                            }
                        }

                    }

                }

                FlowRow(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    TextButton(onClick = { expanded = false }) {
                        Text("Cancel")
                    }
                    Spacer(modifier = Modifier.width(8.dp)) // Espacio entre elementos
                    TextButton(onClick = { expanded = false }) {
                        Text("Done")
                    }
                }
            }
        }
    }
}
@Composable
fun ShowToastOnIndexChange(selectedIndex: Int) {
    val context = LocalContext.current

    LaunchedEffect(selectedIndex) {
            Toast.makeText(context, "HOLLA", Toast.LENGTH_SHORT).show()

    }
}

