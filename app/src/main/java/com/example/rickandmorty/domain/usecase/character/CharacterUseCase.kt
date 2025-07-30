package com.example.rickandmorty.domain.usecase.character

import com.example.rickandmorty.data.remote.dto.toCharacter
import com.example.rickandmorty.domain.repository.CharacterRepository
import com.example.rickandmorty.domain.model.Character
import com.example.rickandmorty.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class CharacterUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    fun getCharacter(): Flow<Resource<List<Character>>> = flow {
        try {
            emit(Resource.Loading())
            val characterDtos = characterRepository.getAllCharacters()
            val allCharacters = characterDtos.flatMap { it.toCharacter() }
            emit(Resource.Success(allCharacters))
        } catch (e: HttpException){
            emit(Resource.Error(message = "${e.localizedMessage}"))
        }
    }

    fun searchCharacter(name: String) : Flow<Resource<List<Character>>> = flow {
        try {
            emit(Resource.Loading())
            val characterDtos = characterRepository.getSearchedCharacters(name)
            val allCharacter = characterDtos.flatMap { it.toCharacter() }
            emit(Resource.Success(allCharacter))
        } catch (e: Exception) {
            emit(Resource.Error(message = "${e.localizedMessage}"))
        }
    }
}