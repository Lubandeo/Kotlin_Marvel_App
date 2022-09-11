package com.example.appmarvel.mvvm.model

import com.example.appmarvel.entity.Character
import com.example.appmarvel.usecase.GetCharactersListUseCase
import com.example.appmarvel.service.utils.Result
import org.koin.core.component.KoinComponent

class CharacterListModel(private val getCharacterListUseCase: GetCharactersListUseCase) {

    fun getCharactersList(): Result<List<Character>> = getCharacterListUseCase()
}
