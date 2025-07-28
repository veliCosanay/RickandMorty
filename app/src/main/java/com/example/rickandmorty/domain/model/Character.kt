package com.example.rickandmorty.domain.model

import com.example.rickandmorty.data.remote.dto.Location
import com.example.rickandmorty.data.remote.dto.Origin

data class Character(
    val gender: String,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val status: String,
)
