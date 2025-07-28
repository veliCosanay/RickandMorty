package com.example.rickandmorty.di

import com.example.rickandmorty.data.remote.CharacterAPI
import com.example.rickandmorty.data.repository.CharacterRepositoryImpl
import com.example.rickandmorty.domain.repository.CharacterRepository
import com.example.rickandmorty.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RickandMortyModule {

    @Singleton
    @Provides
    fun provideApi() : CharacterAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharacterAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(characterAPI: CharacterAPI): CharacterRepository {
        return CharacterRepositoryImpl(characterAPI)
    }
}