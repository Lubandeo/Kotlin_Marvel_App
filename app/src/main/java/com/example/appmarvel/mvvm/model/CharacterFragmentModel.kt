package com.example.appmarvel.mvvm.model

import com.example.appmarvel.entity.Character
import com.example.appmarvel.service.utils.Result
import com.example.appmarvel.usecase.GetCharacterByIdUseCase

class CharacterFragmentModel(private val getCharacterByIdUseCase: GetCharacterByIdUseCase) {
    fun getCharacterById(characterId: String): Result<Character> = getCharacterByIdUseCase(characterId)
}
