package com.project.condosa.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.project.condosa.ui.components.view.GastoPredio.GastosPredio
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
    }
}