package com.example.rickandmorty.presentation.character

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.usecase.character.CharacterUseCase
import com.example.rickandmorty.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterUseCase: CharacterUseCase
) : ViewModel() {


    private val _characterState = mutableStateOf(CharacterState())
    val characterState: State<CharacterState> = _characterState

    init {
        getCharacter()
    }

    private var job: Job? = null

    private fun getCharacter() {
        job?.cancel()
        job = characterUseCase.getCharacter().onEach {
            when(it) {
                is Resource.Error ->{
                    _characterState.value = _characterState.value.copy(
                        error = it.message ?: "error",
                        isLoading = false
                    )
                }
                is Resource.Success ->{
                    _characterState.value = _characterState.value.copy(
                        character = it.data ?: emptyList(),
                        isLoading = false
                    )
                }
                is Resource.Loading ->{
                    _characterState.value = _characterState.value.copy(
                        isLoading = false
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

}