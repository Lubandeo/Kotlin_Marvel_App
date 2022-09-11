package com.example.appmarvel.service.serviceimplementation

import com.example.appmarvel.entity.Character
import com.example.appmarvel.service.ServiceGenerator
import com.example.appmarvel.service.api.MarvelApi
import com.example.appmarvel.service.serviceinterface.MarvelService
import com.example.appmarvel.service.utils.Result
import com.example.appmarvel.service.utils.transformData
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MarvelServiceImpl(private val api: ServiceGenerator) : MarvelService {

    override fun getCharactersList(): Result<List<Character>> {
        try {
            val callResponse = api.createService(MarvelApi::class.java).getCharactersList()
            val response = callResponse.execute()
            if (response.isSuccessful)
                response.body()?.let {
                    return Result.Success(it.transformData())
                }
        } catch (e: Exception) {
            return Result.Failure(e)
        }
        return Result.Failure(Exception(CHARACTERS_NOT_FOUND))
    }

    companion object {
        private const val CHARACTERS_NOT_FOUND = "CHARACTERS_NOT_FOUND"
    }
}
