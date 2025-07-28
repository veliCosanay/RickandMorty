package com.example.rickandmorty.presentation.character

import com.example.rickandmorty.domain.model.Character

data class CharacterState(
    val isLoading: Boolean = false,
    val character: List<Character> = emptyList(),
    val error: String? = ""
)
