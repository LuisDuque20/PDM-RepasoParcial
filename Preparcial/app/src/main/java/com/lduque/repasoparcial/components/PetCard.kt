package com.lduque.repasoparcial.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lduque.repasoparcial.models.Pet
import coil.compose.AsyncImage


@Composable
fun PetCard(pet: Pet, onClick: () -> Unit){
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable{onClick()}
    )
    {
        Row(modifier = Modifier.padding(16.dp)){
            AsyncImage(
                model =
                    pet.photo,
                    contentDescription = "Foto de ${pet.name}",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column{
                Text(text = pet.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = "${pet.type} - edad: ${pet.age}", fontSize = 14.sp, color = Color.Gray)
            }
        }
    }
}