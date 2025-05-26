package com.lduque.repasoparcial.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.TextField

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lduque.repasoparcial.components.PetCard
import com.lduque.repasoparcial.components.navBarTopBar
import com.lduque.repasoparcial.ui.theme.RepasoParcialTheme
import com.lduque.repasoparcial.viewModel.HomeScreenViewModel

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel: HomeScreenViewModel = viewModel()
    val filteredPets = viewModel.filteredPets.value

    navBarTopBar(navController) {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(10.dp)
        ) {
            TextField(
                value = viewModel.buscar,
                onValueChange = { viewModel.actualizarBusqueda(it) },
                label = { Text("Busca una mascota", color = Color.Black) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Spacer(Modifier.height(10.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(10.dp)
            ) {
                items(filteredPets) { pet ->
                    PetCard(pet = pet) {
                        navController.navigate("PetScreen/${pet.id}")
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    val navController = rememberNavController()
    RepasoParcialTheme {
        HomeScreen(navController)
    }
}