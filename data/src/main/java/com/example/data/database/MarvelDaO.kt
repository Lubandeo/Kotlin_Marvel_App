package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.entity.CharacterEntity

@Dao
interface MarvelDaO {
    @Query("SELECT * FROM character_table")
    fun getCharacters(): List<CharacterEntity>

    @Query("SELECT * FROM character_table WHERE id = :characterId")
    fun getCharacterById(characterId: String): List<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacter(characterEntity: CharacterEntity)
}
