package com.example.rickandmorty.presentation.character

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rickandmorty.presentation.character.components.CharacterItem

@Composable
fun CharacterScreen(
    characterViewModel: CharacterViewModel = hiltViewModel()
) {
    val state = characterViewModel.characterState.value

    Box(
       modifier = Modifier.fillMaxSize()
    ){
        LazyColumn {
            items(state.character) {
                CharacterItem(it)
            }
        }
    }
}