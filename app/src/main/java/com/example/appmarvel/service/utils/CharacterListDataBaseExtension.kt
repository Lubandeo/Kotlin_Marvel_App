package com.example.appmarvel.service.utils

import com.example.appmarvel.database.CharacterEntity
import com.example.appmarvel.entity.Character

fun List<CharacterEntity>.transformListCharacterEntity(): List<Character> {
    val characterList = mutableListOf<Character>()
    forEach {
        characterList.add(
            Character(
                it.id,
                it.name,
                it.description
            )
        )
    }
    return characterList
}
