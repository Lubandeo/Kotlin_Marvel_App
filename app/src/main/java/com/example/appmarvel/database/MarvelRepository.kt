package com.example.appmarvel.database

import com.example.appmarvel.entity.Character
import com.example.appmarvel.service.utils.Result

interface MarvelRepository {
    fun getCharacters(): Result<List<Character>>
    fun getCharacterById(id: String): Result<Character>
    fun updateCharacters(charactersList: List<Character>)
    fun updateCharacterById(character: Character)
}
