package com.project.condosa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.project.condosa.ui.theme.CondosaTheme
import com.project.condosa.ui.components.view.Gastos_Agregar.GastoAgregar



import com.project.condosa.ui.components.view.Initial.HomeContent // Reemplaza "your.package.name" con el nombre real de tu paquete
import com.project.condosa.ui.components.view.Initial.View // Reemplaza "your.package.name" con el nombre real de tu paquete

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CondosaTheme {
                // A surface container using the 'background' color from the theme
                /*
                * Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    //Greeting("Android Rama")

                    //LO PONEN ENCOMENTARIOS Y PONEN SUS CODIGOS
                   // HomeContent("user@email.com", "Some Provider")
                    //View("User Name", "user@email.com", "Some Provider")
                    GastoAgregar()
                }

                * */
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    GastoAgregar()
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
        //Greeting("Android")
        //LO PONEN ENCOMENTARIOS Y PONEN SUS CODIGOS
        //HomeContent("user@email.com", "Some Provider")
        //View("User Name", "user@email.com", "Some Provider")
        GastoAgregar()
    }
}