package com.example.rickandmorty.presentation.character.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmorty.domain.model.Character
import com.example.rickandmorty.util.ImageFromUrl

@Composable
fun CharacterItem(character: Character, color: Color) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(horizontal = 10.dp, vertical = 10.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                ImageFromUrl(character.image)
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Column(
                modifier = Modifier
                    .weight(2f)
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = character.name,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(color)
                    )
                    Spacer(modifier = Modifier.padding(end = 5.dp))
                    Text(
                        text = character.status,
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.padding(end = 5.dp))
                    Text(text = "-")
                    Spacer(modifier = Modifier.padding(end = 5.dp))
                    Text(
                        text = character.gender,
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Column {
                    Text(
                        text = "Last known location: ",
                        color = Color.LightGray
                    )
                    Text(
                        text = character.location.name,
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Normal,
                        color = Color.White
                    )
                }
            }
        }
    }
}