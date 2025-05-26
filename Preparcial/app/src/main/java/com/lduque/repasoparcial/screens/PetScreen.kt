package com.lduque.repasoparcial.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.lduque.repasoparcial.components.navBarTopBar
import com.lduque.repasoparcial.ui.theme.RepasoParcialTheme
import com.lduque.repasoparcial.viewModel.PetViewModel

@Composable
fun PetScreen(navController: NavController, petId: Int){
    val modifier = Modifier
    val petViewModel: PetViewModel = viewModel()
    LaunchedEffect(petId){
        petViewModel.loadPet(petId)
    }
    val pet = petViewModel.pet
    navBarTopBar(navController){
        if(pet != null){
            Column(modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(20.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ){
                AsyncImage(model = pet.photo, contentDescription = " ${pet.description} ")
                Text(text="${pet.name} - ${pet.age} \n ${pet.description}")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PetScreenPreview(){
    val navController = rememberNavController()
    RepasoParcialTheme{
        PetScreen(navController, petId = 1)
    }
}