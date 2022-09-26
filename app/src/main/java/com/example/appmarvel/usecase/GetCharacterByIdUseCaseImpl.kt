package com.example.appmarvel.usecase

import com.example.appmarvel.database.MarvelRepository
import com.example.appmarvel.entity.Character
import com.example.appmarvel.service.serviceinterface.MarvelService
import com.example.appmarvel.service.utils.Result

interface GetCharacterByIdUseCase {
    operator fun invoke(characterId: String): Result<Character>
}

class GetCharacterByIdUseCaseImpl(
    private val marvelService: MarvelService,
    private val marvelRepository: MarvelRepository
) : GetCharacterByIdUseCase {

    override operator fun invoke(characterId: String): Result<Character> {
        return when (val serviceResult = marvelService.getCharacterById(characterId)) {
            is Result.Success -> {
                marvelRepository.updateCharacterById(serviceResult.data)
                marvelRepository.getCharacterById(serviceResult.data.id)
            }
            is Result.Failure -> marvelRepository.getCharacterById(characterId)
        }
    }
}
