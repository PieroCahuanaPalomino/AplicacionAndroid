package com.project.condosa.ui.components.view.Initial

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.project.condosa.data.remoto.ImplementacionAPI.APIGastoPredioImplementacion
import com.project.condosa.domain.model.Casa
import com.project.condosa.domain.model.GastoPredio
import com.project.condosa.domain.model.TipoGastoPredio
import com.project.condosa.ui.components.view.GastoPredio.VentanaEditarGasto
import com.project.condosa.ui.components.view.GastoPredio.poppins
import com.project.condosa.ui.components.view.GastoPredio.tipoGastomonto
import androidx.compose.runtime.LaunchedEffect
import com.project.condosa.data.remoto.ImplementacionApi.ApiPredioServiceImplementation
import com.project.condosa.domain.model.ApiResponseCasa
import retrofit2.Response

@Composable
fun VerDatos(navController: NavController,
             datoNumero: Int             ){


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
                                text = "Id",
                                fontSize = 16.sp,
                                fontFamily = poppins,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.weight(0.2f)
                            )

                            Text(
                                text = "Estado",
                                fontSize = 16.sp,
                                fontFamily = poppins,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.weight(0.5f)
                            )

                            Text(
                                text = "responsable",
                                fontSize = 16.sp,
                                fontFamily = poppins,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.weight(1.2f)
                            )
                            Text(
                                text = "Area",
                                fontSize = 16.sp,
                                fontFamily = poppins,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.weight(0.5f)
                            )

                        }
                    }
                    var tiposGastos: List<TipoGastoPredio> by remember { mutableStateOf((emptyList())) }
                    var casasLista by remember { mutableStateOf<List<Casa>>(emptyList()) }


                    LaunchedEffect(datoNumero) {
                        val apiService = ApiPredioServiceImplementation()
                        val responseCasa: Response<ApiResponseCasa> =
                            apiService.getCasas(datoNumero)
                        val nuevosGastos = mutableListOf<GastoPredio>()
                        if(responseCasa.isSuccessful){
                            val apiResponseCasa = responseCasa.body()
                            var listCasas : List<Casa> = apiResponseCasa?.casas!!.toList()
                            casasLista=listCasas
                        }


                    }



                    val tipoGastomonto = tipoGastomonto(casasLista.size)


                    LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .width(400.dp) // Establece el ancho deseado para la tabla
                                //.horizontalScroll(rememberScrollState())

                                .background(Color(0xFFF6F8FF)) // Color de fondo de la tabla
                            // contentPadding = PaddingValues(horizontal = 14.dp)
                        ) {

                            items(casasLista.size) { index ->
                                val tipoGasto = casasLista[index]
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp, vertical = 4.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,

                                    ) {

                                    Text(
                                        text = tipoGasto.id_indice.toString(),
                                        fontSize = 15.sp,
                                        fontFamily = poppins,
                                        fontWeight = FontWeight.Normal,
                                        modifier = Modifier.weight(0.2f)
                                    )

                                    Text(
                                        text = tipoGasto.estado.toString(),
                                        fontSize = 15.sp,
                                        fontFamily = poppins,
                                        fontWeight = FontWeight.Normal,
                                        modifier = Modifier.weight(0.6f)
                                    )
                                    Text(
                                        text = tipoGasto.responsable.toString()
                                        ,
                                        fontSize = 15.sp,
                                        fontFamily = poppins,
                                        modifier = Modifier.weight(1.6f)
                                    )
                                    Text(
                                        text = tipoGasto.area_total.toString(),
                                        fontSize = 15.sp,
                                        fontFamily = poppins,
                                        modifier = Modifier.weight(0.5f)
                                    )




                                }
                            }
                        }
                    }
                }
        }
    }
}