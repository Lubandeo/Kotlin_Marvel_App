package com.example.appmarvel.service.serviceimplementation

import com.example.appmarvel.entity.Character
import com.example.appmarvel.service.ServiceGenerator
import com.example.appmarvel.service.api.MarvelApi
import com.example.appmarvel.service.serviceinterface.MarvelService
import com.example.appmarvel.service.utils.Constants.CHARACTERS_NOT_FOUND
import com.example.appmarvel.service.utils.Constants.CHARACTER_NOT_FOUND
import com.example.appmarvel.service.utils.Result
import com.example.appmarvel.service.utils.extension.transformDataResponse
import com.example.appmarvel.service.utils.extension.transformToCharacter

class MarvelServiceImpl(private val api: ServiceGenerator) : MarvelService {

    override fun getCharactersList(): Result<List<Character>> {
        try {
            val callResponse = api.createService(MarvelApi::class.java).getCharactersList()
            val response = callResponse.execute()
            if (response.isSuccessful)
                response.body()?.let {
                    return Result.Success(it.transformDataResponse())
                }
        } catch (e: Exception) {
            return Result.Failure(e)
        }
        return Result.Failure(Exception(CHARACTERS_NOT_FOUND))
    }

    override fun getCharacterById(characterId: String): Result<Character> {
        try {
            val callResponse =
                api.createService(MarvelApi::class.java).getCharacterById(characterId)
            val response = callResponse.execute()
            if (response.isSuccessful)
                response.body()?.let { return Result.Success(it.transformToCharacter()) }
        } catch (e: Exception) {
            return Result.Failure(e)
        }
        return Result.Failure(Exception(CHARACTER_NOT_FOUND))
    }
}
