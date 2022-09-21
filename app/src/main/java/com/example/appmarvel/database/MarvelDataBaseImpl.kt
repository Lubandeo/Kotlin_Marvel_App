package com.example.appmarvel.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.appmarvel.entity.Character
import com.example.appmarvel.service.utils.Result
import com.example.appmarvel.service.utils.extension.transformCharacter
import com.example.appmarvel.service.utils.extension.transformListCharacterEntity

@Database(
    entities = [CharacterEntity::class],
    version = 1
)

abstract class MarvelDataBaseImpl : RoomDatabase(), MarvelDataBase {

    abstract fun marvelDaO(): MarvelDaO

    override fun getCharacters(): Result<List<Character>> = marvelDaO().getCharacters().let {
        if (it.isNotEmpty()) {
            Result.Success(it.transformListCharacterEntity())
        } else {
            Result.Failure(Exception(ERROR_CHARACTERS_NOT_FOUND))
        }
    }

    override fun updateCharacters(charactersList: List<Character>) {
        charactersList.forEach {
            marvelDaO().insertCharacter(it.transformCharacter())
        }
    }

    companion object {
        private const val ERROR_CHARACTERS_NOT_FOUND = "ERROR_CHARACTERS_NOT_FOUND"
    }
}
