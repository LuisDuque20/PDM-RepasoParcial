package com.lduque.repasoparcial

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lduque.repasoparcial.screens.HomeScreen
import com.lduque.repasoparcial.screens.PetScreen

@Composable
fun navigationStack(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "HomeScreen"){
        composable("HomeScreen"){
            HomeScreen(navController = navController)
        }
        composable("PetScreen/{petId}"){ backStackEntry ->
            val petId = backStackEntry.arguments?.getString("petId")?.toIntOrNull()
            petId?.let{
                PetScreen(navController = navController, petId = it)
            }
        }
    }
}