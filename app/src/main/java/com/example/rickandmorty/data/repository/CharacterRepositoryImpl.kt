package com.example.rickandmorty.data.repository

import com.example.rickandmorty.data.remote.CharacterAPI
import com.example.rickandmorty.data.remote.dto.CharacterDto
import com.example.rickandmorty.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val characterAPI: CharacterAPI
) : CharacterRepository {
    override suspend fun getAllCharacters(): List<CharacterDto> {
        val allCharacters = mutableListOf<CharacterDto>()
        var page = 1
        var hasNextPage = true

        while (hasNextPage) {
            try {
                val response = characterAPI.getCharacter(page)
                allCharacters.add(response)
                hasNextPage = response.info.next != null
                page++
            } catch (e: Exception) {
                hasNextPage = false
            }
        }

        return allCharacters
    }

    override suspend fun getSearchedCharacters(name: String): List<CharacterDto> {
        val allCharacters = mutableListOf<CharacterDto>()
        var page = 1
        var hasNextPage = true

        while (hasNextPage) {
            try {
                val response = characterAPI.getCharacter(page, name)
                allCharacters.add(response)
                hasNextPage = response.info.next != null
                page++
            } catch (e: Exception) {
                hasNextPage = false
            }
        }

        return allCharacters
    }
}