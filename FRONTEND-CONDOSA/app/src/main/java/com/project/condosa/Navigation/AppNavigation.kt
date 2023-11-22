package com.project.condosa.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.project.condosa.ui.components.view.GastoPredio.GastosPredio
import com.project.condosa.ui.components.view.Gastos_casa.ViewGastos
import com.project.condosa.ui.components.view.Initial.VerDatos
import com.project.condosa.ui.components.view.Initial.View

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.HomeActivity.route){
        composable(route = AppScreens.HomeActivity.route ,
         ){
            View(
                navController = navController,
            )
        }
        composable(route = AppScreens.VentanaGastoPredio.route + "/{name}/{period}",
            arguments = listOf(
                navArgument(name="name"){type = NavType.StringType},
                navArgument(name="period"){type = NavType.StringType}
                )){backStackEntry ->
            GastosPredio(
                navController,
                name = backStackEntry.arguments?.getString("name")?: "",
                period = backStackEntry.arguments?.getString("period")?: ""
            )
        }
        composable(
            route = "${AppScreens.VerDatos.route}/{datoNumero}",
            arguments = listOf(
                navArgument(name = "datoNumero") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            VerDatos(
                navController = navController,
                datoNumero = backStackEntry.arguments?.getInt("datoNumero") ?: 0
            )
        }

        composable(route = AppScreens.Gasto_casa.route + "/{name}",
            arguments = listOf(
                navArgument(name="name"){type = NavType.StringType}
            )){backStackEntry ->

            ViewGastos(
                navController,
                name = backStackEntry.arguments?.getString("name")?: ""
            )
        }

    }
}
