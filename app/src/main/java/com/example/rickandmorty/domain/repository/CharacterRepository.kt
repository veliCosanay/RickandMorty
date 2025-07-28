package com.example.rickandmorty.domain.repository

import com.example.rickandmorty.data.remote.dto.CharacterDto

interface CharacterRepository {
    suspend fun getAllCharacters(): List<CharacterDto>
}