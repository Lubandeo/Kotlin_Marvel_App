package com.example.appmarvel.usecase

import com.example.appmarvel.database.MarvelRepository
import com.example.appmarvel.entity.Character
import com.example.appmarvel.service.serviceinterface.MarvelService
import com.example.appmarvel.service.utils.Result

interface GetCharactersListUseCase {
    operator fun invoke(): Result<List<Character>>
}

class GetCharactersListUseCaseImpl(
    private val marvelService: MarvelService,
    private val marvelRepository: MarvelRepository
) :
    GetCharactersListUseCase {

    override operator fun invoke(): Result<List<Character>> {
        return when (val serviceResult = marvelService.getCharactersList()) {
            is Result.Success -> {
                marvelRepository.updateCharacters(serviceResult.data)
                marvelRepository.getCharacters()
            }
            is Result.Failure -> marvelRepository.getCharacters()
        }
    }
}
