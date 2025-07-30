package com.example.rickandmorty.presentation.character

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rickandmorty.presentation.character.components.CharacterItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterScreen(
    characterViewModel: CharacterViewModel = hiltViewModel()
) {
    val state = characterViewModel.characterState.value

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    OutlinedTextField(
                        value = characterViewModel.searchQuery.value,
                        onValueChange = { query ->
                            characterViewModel.onSearchQuery(query)
                        },
                        label = { Text("Character Search") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Search,
                                contentDescription = "Search icon",
                                tint = Color.Black
                            )
                        },
                        shape = RoundedCornerShape(20.dp)
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Menu,
                            contentDescription = "Menu icon",
                            tint = Color.Black
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyColumn {
                items(state.character) { character ->
                    val statusColor = characterViewModel.isAlive(character.status)
                    CharacterItem(character = character, color = statusColor)
                }
            }
        }
    }
}