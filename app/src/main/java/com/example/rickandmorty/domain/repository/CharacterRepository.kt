package com.example.rickandmorty.domain.repository

import com.example.rickandmorty.data.remote.dto.CharacterDto
import com.example.rickandmorty.domain.model.Character

interface CharacterRepository {
    suspend fun getAllCharacters(): List<CharacterDto>
    suspend fun getSearchedCharacters(name: String): List<CharacterDto>
}