package com.project.condosa

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.project.condosa.data.remoto.ImplementacionApi.ApiPredioServiceImplementation
import com.project.condosa.data.remoto.ObjectRetrofit.RetrofitClient
import com.project.condosa.data.remoto.api.SupperHeroResponse
import com.project.condosa.domain.model.ApiResponsePredio
import com.project.condosa.ui.components.view.GastoPredio.GastosPredio
import com.project.condosa.ui.theme.CondosaTheme
import com.project.condosa.ui.components.view.Initial.HomeContent // Reemplaza "your.package.name" con el nombre real de tu paquete
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

//import com.project.condosa.ui.components.view.Initial.View // Reemplaza "your.package.name" con el nombre real de tu paquete

class MainActivity : ComponentActivity() {
    val retrofit = RetrofitClient.getInstance()
    val apiService = ApiPredioServiceImplementation()
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContent {
            CondosaTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    //Greeting("Android Rama")

                    //LO PONEN ENCOMENTARIOS Y PONEN SUS CODIGOS
                    //HomeContent("user@email.com", "Some Provider")
                    lifecycleScope.launch(Dispatchers.IO) {
                        try {
                            val response: Response<ApiResponsePredio> = apiService.getPredios()
                            withContext(Dispatchers.Main) {
                                if (response.isSuccessful) {
                                    val apiResponse = response.body()
                                    val success = apiResponse?.success ?: false

                                    // Muestra el valor de success en el Toast
                                    Toast.makeText(this@MainActivity, "Success: $success", Toast.LENGTH_SHORT).show()
                                }
                            }
                        } catch (e: Exception) {
                            // Manejar errores, por ejemplo, mostrar un mensaje de error en caso de excepción
                            withContext(Dispatchers.Main) {
                                Toast.makeText(this@MainActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    //View("User Name", "user@email.com", "Some Provider")
                    //GastosPredio(name="Los Rosales", period = "2023-I")
                }
            }
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CondosaTheme {
        Greeting("Android")
        //LO PONEN ENCOMENTARIOS Y PONEN SUS CODIGOS
        //HomeContent("user@email.com", "Some Provider")
        //View("User Name", "user@email.com", "Some Provider")
        //GastosPredio(name="Los Rosales", period = "2023-I")
    }
}