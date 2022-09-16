package com.example.appmarvel.usecase

import com.example.appmarvel.database.MarvelDataBase
import com.example.appmarvel.entity.Character
import com.example.appmarvel.service.serviceinterface.MarvelService
import com.example.appmarvel.service.utils.Result

interface GetCharactersListUseCase {
    operator fun invoke(): Result<List<Character>>
}

class GetCharactersListUseCaseImpl(private val marvelService: MarvelService, private val marvelDatabase: MarvelDataBase) :
    GetCharactersListUseCase {

    override operator fun invoke(): Result<List<Character>> {
        return when (val serviceResult = marvelService.getCharactersList()){
            is Result.Success -> {
                marvelDatabase.updateCharacters(serviceResult.data)
                marvelDatabase.getCharacters()
            }
            is Result.Failure -> marvelDatabase.getCharacters()
        }
    }
}
