package com.project.condosa.Navigation

sealed class AppScreens(val route: String){
    object HomeActivity: AppScreens("HomeActivity")
    object VentanaGastoPredio: AppScreens("VentanaGastoPredio")
    object VerDatos: AppScreens("VerDatos")
    object Gasto_casa: AppScreens("Gasto_casa")
}
