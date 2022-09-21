package com.example.appmarvel.service.utils.extension

import com.example.appmarvel.entity.Character
import com.example.appmarvel.service.response.DataResponse

fun DataResponse.transformDataResponse(): List<Character> {
    val characterList = mutableListOf<Character>()
    data.results.forEach {
        characterList.add(
            Character(
                it.id,
                it.name,
                it.description,
                it.thumbnail.getURL()
            )
        )
    }
    return characterList
}
