package com.example.rickandmorty.data.remote

import com.example.rickandmorty.data.remote.dto.CharacterDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterAPI {

    @GET("character")
    suspend fun getCharacter(
        @Query("page") page: Int = 1,
        @Query("name") name: String?=null
    ) : CharacterDto


}