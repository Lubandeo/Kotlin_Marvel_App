package com.example.appmarvel.service.utils

import com.example.appmarvel.database.CharacterEntity
import com.example.appmarvel.entity.Character

fun Character.transformCharacter(): CharacterEntity {
    return CharacterEntity(
        this.id,
        this.name,
        this.description)
}
