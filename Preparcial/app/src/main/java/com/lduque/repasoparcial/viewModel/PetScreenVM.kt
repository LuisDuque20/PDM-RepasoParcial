package com.lduque.repasoparcial.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.lduque.repasoparcial.models.Pet
import com.lduque.repasoparcial.models.pets

class PetViewModel: ViewModel(){

    var pet by mutableStateOf<Pet?>(null)
        private set

    //Obtener mascota por su ID
    fun loadPet(petID: Int){
        pet = pets.find { it.id == petID }
    }
}