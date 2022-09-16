package com.example.appmarvel.database

import com.example.appmarvel.entity.Character
import com.example.appmarvel.service.utils.Result

interface MarvelDataBase {
    fun getCharacters():Result<List<Character>>
    fun updateCharacters(charactersList:List<Character>)
}
