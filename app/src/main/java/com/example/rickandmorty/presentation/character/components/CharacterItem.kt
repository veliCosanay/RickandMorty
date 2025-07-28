package com.example.rickandmorty.presentation.character.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rickandmorty.domain.model.Character
import com.example.rickandmorty.util.ImageFromUrl

@Composable
fun CharacterItem(character: Character) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 10.dp, vertical = 20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Box(

            ) {
                ImageFromUrl(character.image)
            }

            Column {
                Text(
                    text = "Name: " + character.name
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    text = "Gender: " + character.gender
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    text = "Last Known Location: " + character.location.name
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    text = "Status: " + character.status
                )
            }
        }

    }
}