package com.example.appmarvel.database

import com.example.appmarvel.entity.Character
import com.example.appmarvel.service.utils.Constants.CHARACTER_NOT_FOUND
import com.example.appmarvel.service.utils.Result
import com.example.appmarvel.service.utils.extension.transformCharacter
import com.example.appmarvel.service.utils.extension.transformListCharacterEntity

class MarvelRepositoryImpl(private val marvelDaO: MarvelDaO) : MarvelRepository {

    override fun getCharacters(): Result<List<Character>> = marvelDaO.getCharacters().let {
        if (it.isNotEmpty()) {
            Result.Success(it.transformListCharacterEntity())
        } else {
            Result.Failure(Exception(ERROR_CHARACTERS_NOT_FOUND))
        }
    }

    override fun getCharacterById(characterId: String): Result<Character> =
        marvelDaO.getCharacterById(characterId).let {
            if (it.isNotEmpty()) {
                Result.Success(it.transformListCharacterEntity().first())
            } else {
                Result.Failure(Exception(CHARACTER_NOT_FOUND))
            }
        }

    override fun updateCharacters(charactersList: List<Character>) {
        charactersList.forEach {
            marvelDaO.insertCharacter(it.transformCharacter())
        }
    }

    override fun updateCharacterById(character: Character) {
        marvelDaO.insertCharacter(character.transformCharacter())
    }

    companion object {
        private const val ERROR_CHARACTERS_NOT_FOUND = "ERROR_CHARACTERS_NOT_FOUND"
    }
}
