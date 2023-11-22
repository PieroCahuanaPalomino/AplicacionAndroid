package com.project.condosa

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.WindowManager
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
import com.project.condosa.Navigation.AppNavigation
import com.project.condosa.ui.components.view.GastoPredioAgregar.GastoPredioagregar
import com.project.condosa.ui.theme.CondosaTheme


class MainActivity : ComponentActivity() {
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
                    //View("User Name", "user@email.com", "Some Provider")
                    //GastosPredio(name="Los Rosales", period = "2023-I")
                    //GastoPredioagregar()

                    //HomeContent("user@email.com", "Some Provider")
                    //View("User Name", "user@email.com", "Some Provider",lifecycleScope)
                    //GastosPredio(name="Los Rosales", period = "2023-I")
                    AppNavigation()
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

        //LO PONEN ENCOMENTARIOS Y PONEN SUS CODIGOS

        //HomeContent("user@email.com", "Some Provider")
        //View("User Name", "user@email.com", "Some Provider")
        //GastosPredio(name="Los Rosales", period = "2023-I")
        //GastoPredioagregar()

        //HomeContent("user@email.com", "Some Provider")
        //View("User Name", "user@email.com", "Some Provider")
        //GastosPredio(name="Los Rosales", period = "2023-I")
        AppNavigation()
    }
}