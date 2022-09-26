package com.example.appmarvel.service.utils.extension

import com.example.appmarvel.entity.Character
import com.example.appmarvel.service.response.CharacterResponse

fun CharacterResponse.transformToCharacter(): Character {
    return Character(
        this.id,
        this.name,
        this.description,
        this.thumbnail.getURL()
    )
}
