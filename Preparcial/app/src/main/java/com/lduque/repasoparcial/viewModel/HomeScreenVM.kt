package com.lduque.repasoparcial.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.lduque.repasoparcial.models.Pet
import com.lduque.repasoparcial.models.pets

class HomeScreenViewModel: ViewModel(){
    private val _types = listOf(
        "Dog",
        "Cat"
    )

    var buscar by mutableStateOf("")
        private set

    var filteredPets = mutableStateOf(pets)
        private set

    fun actualizarBusqueda(nuevoTexto: String){
        buscar = nuevoTexto
        filterPets()
    }

    private fun filterPets(){
        filteredPets.value = pets.filter{ pet ->
            val nameMatch = pet.name.contains(buscar, ignoreCase = true)
            val tipoMatch = pet.type.contains(buscar, ignoreCase = true)

            nameMatch || tipoMatch
        }
    }

    val types: List<String> = _types

    fun getPetsByCategory(tipos: String): List<Pet>{
        return pets.filter { it.type.contains(tipos) }
    }
}