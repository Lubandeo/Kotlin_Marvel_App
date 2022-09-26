package com.example.appmarvel.service.api

import com.example.appmarvel.service.response.CharacterResponse
import com.example.appmarvel.service.response.DataResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelApi {

    @GET("v1/public/characters")
    fun getCharactersList(): Call<DataResponse>

    @GET("v1/public/characters/{characterId}")
    fun getCharacterById(@Path("characterId") characterId: String): Call<CharacterResponse>
}
