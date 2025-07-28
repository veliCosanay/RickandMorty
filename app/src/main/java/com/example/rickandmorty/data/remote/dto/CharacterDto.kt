package com.example.rickandmorty.data.remote.dto

import com.example.rickandmorty.domain.model.Character

data class CharacterDto(
    val info: Info,
    val results: List<Result>
)

fun CharacterDto.toCharacter() : List<Character>{
    return results.map {
        Character(
            gender = it.gender,
            image = it.image,
            location = it.location,
            name = it.name,
            origin = it.origin,
            status = it.status,
        )
    }
}
