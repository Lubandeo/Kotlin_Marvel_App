package com.example.appmarvel.service.utils

import com.example.appmarvel.entity.Character
import com.example.appmarvel.service.response.DataResponse

fun DataResponse.transformData(): List<Character> {
    val characterList = mutableListOf<Character>()
    data.results.forEach {
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
