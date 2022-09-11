package com.example.appmarvel.usecase

import com.example.appmarvel.entity.Character
import com.example.appmarvel.service.serviceinterface.MarvelService
import com.example.appmarvel.service.utils.Result
import org.koin.core.component.KoinComponent

interface GetCharactersListUseCase {
    operator fun invoke(): Result<List<Character>>
}

class GetCharactersListUseCaseImpl(private val marvelService: MarvelService) :
    GetCharactersListUseCase {

    override operator fun invoke(): Result<List<Character>> = marvelService.getCharactersList()
}
